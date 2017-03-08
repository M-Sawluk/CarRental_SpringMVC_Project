package com.michal.carRental.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.michal.carRental.domain.User;
import com.michal.carRental.domain.UserStatus;
import com.michal.carRental.domain.repository.UserRepository;
import com.michal.carRental.exception.ConfirmationExpiredException;
import com.michal.carRental.exception.ConfirmationFailedException;
import com.michal.carRental.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private JavaMailSender javaMailSender;

	private VelocityEngine velocityEngine;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, JavaMailSender javaMailSender,
			VelocityEngine velocityEngine) {
		super();
		this.userRepository = userRepository;
		this.javaMailSender = javaMailSender;
		this.velocityEngine = velocityEngine;
	}

	private static final String ACCOUNT_TEMPLATE_PATH = "accountActivateMail.vm";

	private static final long ONE_DAY_IN_MS = 24 * 60 * 60 * 1000;

	private static final Logger log = LoggerFactory.getLogger(MailingListServiceImpl.class);

	@Value("#{mailingListServiceProps.noReplyEmailAddress}")
	private String noReplyEmailAddress;

	@Value("#{mailingListServiceProps.confirmAccountUrl}")
	private String confirmAccountUrl;

	@Value("#{mailingListServiceProps.confirmationAccountKey}")
	private String confirmationAccountKey;

	public void createUser(User user) {

		user.setDateCreated(new Date());
		userRepository.createUser(user);

		sendConfirmation(user);

	}

	public User getUserByUserName(String userName) {

		return userRepository.getUserByUserName(userName);
	}

	public void updateUser(User user) {
		userRepository.updateUser(user);
	}

	public List<User> getUserList() {
		return userRepository.getUserList();
	}

	public void deleteUser(String name) {
		userRepository.deleteUser(name);
	}

	public void changeUserRole(User user, String role) {
		userRepository.changeUserRole(user, role);
	}

	public User getUser(long id) {
		return userRepository.getUser(id);
	}

	public void confirmUser(long userId, String digest) throws ConfirmationFailedException {
		User user = getUser(userId);

		checkTimestamp(user.getDateCreated().getTime());

		String expectedDigest = generateAccountDigest(user);
		if (!digest.equals(expectedDigest)) {
			throw new ConfirmationFailedException("Errore");
		}

		log.info("Activating account: " + user);

		user.setStatus(UserStatus.ACTIVE);

		user.setPassword1(user.getPassword());

		updateUser(user);
	}

	private void sendConfirmation(User user) {
		log.info("Sending account confirm to : " + user);

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper help = new MimeMessageHelper(message);

		String digest = generateAccountDigest(user);
		String url = confirmAccountUrl + "?s=" + user.getId() + "&amp;d=" + digest;

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("user", user);
		map.put("url", url);

		@SuppressWarnings("deprecation")
		String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, ACCOUNT_TEMPLATE_PATH, map);

		try {
			help.setSubject("Accept your account");
			help.setTo(user.getEmail());
			help.setFrom(noReplyEmailAddress);
			help.setSentDate(new Date());
			help.setText(text, true);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		javaMailSender.send(message);

	}

	private String generateAccountDigest(User user) {
		return DigestUtils.shaHex(user.getId() + ":" + confirmationAccountKey);
	}

	private static void checkTimestamp(long timestamp) throws ConfirmationExpiredException {

		long now = System.currentTimeMillis();
		if (now - timestamp > ONE_DAY_IN_MS) {
			throw new ConfirmationExpiredException();
		}
	}

	public void upadateUserWithChangedPass(User user) {
		userRepository.upadateUserWithChangedPass(user);
	}
}

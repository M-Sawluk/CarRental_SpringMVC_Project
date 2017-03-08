package com.michal.carRental.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.apache.commons.codec.digest.DigestUtils;

import com.michal.carRental.domain.Subscriber;
import com.michal.carRental.exception.ConfirmationExpiredException;
import com.michal.carRental.exception.ConfirmationFailedException;
import com.michal.carRental.service.MailingListService;
import com.michal.carRental.service.SubscriberService;

@Service
public class MailingListServiceImpl implements MailingListService{

	private SubscriberService subscriberService;
	
	private JavaMailSender javaMailSender;
	
	private VelocityEngine velocityEngine;
	
	@Autowired
	public MailingListServiceImpl(SubscriberService subscriberService, JavaMailSender javaMailSender,
			VelocityEngine velocityEngine) {
		super();
		this.subscriberService = subscriberService;
		this.javaMailSender = javaMailSender;
		this.velocityEngine = velocityEngine;
	}

	private static final String SUBSCRIBE_TEMPLATE_PATH = "mailingListSubscribe.vm";

	private static final long ONE_DAY_IN_MS = 24 * 60 * 60 * 1000;
	
	private static final Logger log = LoggerFactory.getLogger(MailingListServiceImpl.class);
	
	@Value("#{mailingListServiceProps.noReplyEmailAddress}")
	private String noReplyEmailAddress;
	
	@Value("#{mailingListServiceProps.confirmSubscriptionUrl}")
	private String confirmSubscriptionUrl;
	
	@Value("#{mailingListServiceProps.confirmationKey}")
	private String confirmationKey;
	
	@Override
	public Subscriber getSubscriber(long id) {
		
		return subscriberService.getSubscriber(id);
	}

	@Override
	@Async
	public void addSubscriber(Subscriber subscriber) {

		log.info("Adding unconfirmed subscriber: " + subscriber);
		
		subscriberService.addSubscriber(subscriber);
		
		sendConfirmation(subscriber);
		
	}

	@Override
	public void confirmSubscriber(long subscriberId, String digest) throws ConfirmationFailedException {
		
		Subscriber subscriber = getSubscriber(subscriberId);
		
		checkTimestamp(subscriber.getDateCreated().getTime());
		
		String expectedDigest = generateSubscriptionDigest(subscriber);
		if (!digest.equals(expectedDigest)) {
			throw new ConfirmationFailedException("Bad digest");
		}
		
		
		log.info("Confirming subscriber: " + subscriber);
		
		subscriber.setConfirmed(true);
		
		
		
		subscriberService.updateSubsriber(subscriber);
		
	}

	private void sendConfirmation(Subscriber subscriber)
	{
		log.info("Sending confirm subscription e-mail to: " + subscriber);
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		String digest = generateSubscriptionDigest(subscriber);
		String url = confirmSubscriptionUrl + "?s=" + subscriber.getId() + "&amp;d=" + digest;
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("subscriber", subscriber);
		model.put("url", url);
		
		@SuppressWarnings("deprecation")
		String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, SUBSCRIBE_TEMPLATE_PATH, model);
		
		try {
			helper.setSubject("Please confirm your subscription");
			helper.setTo(subscriber.getEmail());
			helper.setFrom(noReplyEmailAddress);
			helper.setSentDate(subscriber.getDateCreated());
			helper.setText(text, true);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		javaMailSender.send(message);
	}
	
	private String generateSubscriptionDigest(Subscriber subscriber) {
		return  DigestUtils.shaHex(subscriber.getId() + ":" + confirmationKey);
	}
	
	private static void checkTimestamp(long timestamp) throws ConfirmationExpiredException {
		
		long now = System.currentTimeMillis();
		if (now - timestamp > ONE_DAY_IN_MS) {
			throw new ConfirmationExpiredException();
		}
	}
	
}

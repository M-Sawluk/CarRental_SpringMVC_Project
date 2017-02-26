package com.michal.carRental.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.michal.carRental.domain.Subscriber;
import com.michal.carRental.exception.ConfirmationExpiredException;
import com.michal.carRental.exception.ConfirmationFailedException;
import com.michal.carRental.service.MailingListService;
import com.michal.carRental.service.SubscriberService;
import com.michal.carRental.validator.RecaptchaFormValidator;

@Controller
public class MailingController {

	@Autowired
	private MailingListService mailingListService;
	
	@Autowired
	private SubscriberService subscriberService;
	
	@Autowired
	private RecaptchaFormValidator recaptchaFormValidator;
	
	@ModelAttribute("recaptchaSiteKey")
	public String getRecaptchaSiteKey(@Value("#{reCaptcha.site}") String recaptchaSiteKey) {
	    return recaptchaSiteKey;
	}
	
	@RequestMapping(value = "/subscribe" , method= RequestMethod.GET)
	public String mailingForm(@RequestParam("mail") String mail,Model model)
	{
		Subscriber subscriber = new Subscriber();
		subscriber.setEmail(mail);
		
		model.addAttribute("subscriber", subscriber);
		
		return "subscribe";
	}
	
	@RequestMapping(value = "/subscribe" , method= RequestMethod.POST)
	public String mailingFormProcess(@ModelAttribute("subscriber") @Valid Subscriber subscriber , BindingResult bindingResult, HttpServletRequest httpServletRequest)
	{
		if(bindingResult.hasErrors())
		{	
			return "subscribe";
		}
		
		subscriber.setIpAddress(httpServletRequest.getRemoteAddr());
		subscriber.setDateCreated(new Date());
		mailingListService.addSubscriber(subscriber);
		
		return "redirect:/subscribe-preconfirm";
	}
	
	@RequestMapping(value = "/subscribe-preconfirm" )
	public String preConfirm()
	{
		return "subscribe-preconfirm";
	}
	
	@RequestMapping(value = "/subscribe-confirm", method = RequestMethod.GET)
	public String confirmSubscription(@RequestParam("s") Long subscriberId,@RequestParam("d") String digest,Model model) 
	{
			try 
			{
				mailingListService.confirmSubscriber(subscriberId, digest);
				
				model.addAttribute("name",subscriberService.getSubscriber(subscriberId));
				
				return "subscribeSuccess";
			} 
			catch (ConfirmationExpiredException e) {
			model.addAttribute("expired", true);
			} 
			catch (ConfirmationFailedException e) {
			model.addAttribute("failed", true);
			}
			
			model.addAttribute(new Subscriber());
			return "subscribe";
		}
	
	@InitBinder("subscriber")
	public void initBinder(WebDataBinder binder) {
	    binder.addValidators(recaptchaFormValidator);
	}
}

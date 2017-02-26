package com.michal.carRental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.michal.carRental.domain.User;
import com.michal.carRental.exception.ConfirmationExpiredException;
import com.michal.carRental.exception.ConfirmationFailedException;
import com.michal.carRental.forms.Email;
import com.michal.carRental.forms.FormUser;
import com.michal.carRental.service.OrderService;
import com.michal.carRental.service.UserService;
import com.michal.carRental.validator.RecaptchaFormValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RecaptchaFormValidator recaptchaFormValidator;
	
	@ModelAttribute("recaptchaSiteKey")
	public String getRecaptchaSiteKey(@Value("#{reCaptcha.site}") String recaptchaSiteKey) {
	    return recaptchaSiteKey;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(Model model) {
		User newUser = new User();
		model.addAttribute("newUser", newUser);

		return "registration";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUpProcess(@ModelAttribute("newUser") @Valid User newUser,BindingResult result, Model model) {

		if (result.hasErrors()) {

			return "registration";
		}

		userService.createUser(newUser);

		model.addAttribute("name", newUser.getName());
		
	

		return "redirect:/registration-preconfirm";
	}
	
	@RequestMapping("/registration-preconfirm")
	public String registrationPre()
	{
		return "registration-preconfirm";
	}
	
	@RequestMapping(value="/registration-confirm" , method=RequestMethod.GET)
	public String confirmReg(@RequestParam("s") Long userId, @RequestParam("d") String digest, Model model)
	{
		try
		{
			userService.confirmUser(userId, digest);
			
			model.addAttribute("name" , userService.getUser(userId));
			
			return "accountSuccess";
		}
		catch(ConfirmationExpiredException e)
		{
			model.addAttribute("expired" , true);
		}
		catch(ConfirmationFailedException e)
		{
			model.addAttribute("failed",true);
		}
		
		model.addAttribute(new User());
		
		return "registration";
	}
	
	@RequestMapping(value ="/userPage" , method = RequestMethod.GET)
	public String userPage(Model model) 
	{
		User newUser = new User();
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   
		newUser = userService.getUserByUserName(auth.getName());
		
		model.addAttribute("newUserF", newUser);
		
		model.addAttribute("newEmail", newUser);
		
		model.addAttribute("pastOrders",orderService.getPastOrders(newUser));
		
		model.addAttribute("presentOrders",orderService.getPresentOrders(newUser));
	
		return "userPage";
	}


	@RequestMapping(value = "/userPage", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("newUserF") @Valid FormUser newUserF,BindingResult result, @ModelAttribute("newEmail") @Valid Email newEmail,BindingResult result1, Model model, 
								HttpServletRequest request ) {

	if (result.hasErrors()) {

		model.addAttribute("error" , "error");
		
		return "userPage";
	}
	if (result1.hasErrors()) {

		model.addAttribute("error" , "error");
		
		return "userPage";
	}
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   
		User oldUser = userService.getUserByUserName(auth.getName());
		
		if(newEmail.getEmail()!=null)
			{
				oldUser.setEmail(newEmail.getEmail());
			}
		else
			{
				oldUser.setAddress(newUserF.getAddress());
				oldUser.setName(newUserF.getName());
				oldUser.setBirth(newUserF.getBirth());
				oldUser.setTelephone(newUserF.getTelephone());
				oldUser.setPassword(newUserF.getPassword());
			}
				
		
		
		model.addAttribute("success" , "success");
		
		if(oldUser.getPassword().length()>=59)
			{
				userService.updateUser(oldUser);
			}
		else
			{
				userService.upadateUserWithChangedPass(oldUser);;
			}
		
		return "redirect:/userPage";
}

	@InitBinder("newUser")
	public void initBinder(WebDataBinder binder) {
	    binder.addValidators(recaptchaFormValidator);
	}
}

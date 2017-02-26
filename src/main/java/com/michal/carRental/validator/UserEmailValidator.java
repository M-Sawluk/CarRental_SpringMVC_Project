package com.michal.carRental.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.michal.carRental.service.impl.JdbcUserDetailsDaoService;



public class UserEmailValidator implements ConstraintValidator<UserEmail, String>{

	@Autowired 
	JdbcUserDetailsDaoService jdbcUserDetailsDaoService;
	
	public void initialize(UserEmail constraintAnnotation) {
		
	}

	
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		
		try
		{
			if(jdbcUserDetailsDaoService.checkEmail(email)==false)
				{
				
					return true;
				}
			else
			{
				return false;
			}
		}
		catch(Exception e){ return true;}
		
	}
	
}

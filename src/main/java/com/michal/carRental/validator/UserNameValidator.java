package com.michal.carRental.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.michal.carRental.service.impl.JdbcUserDetailsDaoService;

public class UserNameValidator implements ConstraintValidator<UserName, String>{

	@Autowired 
	JdbcUserDetailsDaoService jdbcUserDetailsDaoService;
	
	@Override
	public void initialize(UserName constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try
		{
			if(jdbcUserDetailsDaoService.checkUserName(value)==false)
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

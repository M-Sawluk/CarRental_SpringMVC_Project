package com.michal.carRental.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.michal.carRental.service.ProductService;

public class CarIdValidator implements ConstraintValidator<CarId, String> {

	@Autowired
	private ProductService productService;
	
	
	@Override
	public void initialize(CarId constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String carId, ConstraintValidatorContext context) {
		
		try
		{
			if(productService.findCarByCarId(carId)==null)
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

package com.michal.carRental.validator;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class FutureDateValidator implements ConstraintValidator<FutureDate, Date> {

    public void initialize(FutureDate constraintAnnotation) {
    }

    public boolean isValid(Date date, ConstraintValidatorContext context) {
    	
    Date presentDate =new Date();
    	
	if (date!=null && date.getTime()<(presentDate.getTime()+1000*60*60)) {
	    return false;
	}
	return true;
    }



}

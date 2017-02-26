package com.michal.carRental.validator;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = FutureDateValidator.class)
@Documented
public @interface FutureDate {

    String message() default "Your reservation can be made after 1 hour in future, your starting date seems to be in past";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

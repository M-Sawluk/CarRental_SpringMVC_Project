package com.michal.carRental.forms;

import javax.validation.constraints.Pattern;

import com.michal.carRental.validator.UserEmail;

public class Email {
	
	@Pattern(regexp = "[a-zA-Z0-9.!#$%&’*+=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)", message = "{pattern.user.email.validation}")
	@UserEmail
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Email [email=" + email + "]";
	}
}

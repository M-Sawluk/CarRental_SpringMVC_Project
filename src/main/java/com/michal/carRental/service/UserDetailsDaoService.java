package com.michal.carRental.service;

public interface UserDetailsDaoService {

	String findPasswordByUsername(String username);
	
	boolean checkEmail(String email);
	
	boolean checkUserName(String userName);
}

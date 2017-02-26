package com.michal.carRental.domain.repository;

public interface UserDetailsDao {

	String findPasswordByUsername(String username);
	
	boolean checkEmail(String email);
	
	boolean checkUserName(String userName);
}

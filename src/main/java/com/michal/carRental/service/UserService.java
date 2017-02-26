package com.michal.carRental.service;

import java.util.List;

import com.michal.carRental.domain.User;
import com.michal.carRental.exception.ConfirmationFailedException;

public interface UserService {

	public void createUser(User user);
	
	public User getUserByUserName(String userName);
	
	public void updateUser(User user);
	
	public List<User> getUserList();
	
	void deleteUser(String name);
	
	void changeUserRole(User user, String role);
	
	User getUser(long id);
	
	void confirmUser(long userId, String digest) throws ConfirmationFailedException;
	
	void upadateUserWithChangedPass(User user);
}

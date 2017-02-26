package com.michal.carRental.domain.repository;

import java.util.List;

import com.michal.carRental.domain.User;

public interface UserRepository {

	void createUser(User user);
	
	User getUserByUserName(String userName);
	
	void updateUser(User user);
	
	List<User> getUserList();
	
	void deleteUser(String name);
	
	void changeUserRole(User user,String role);
	
	User getUser(long id);
	
	void upadateUserWithChangedPass(User user);
}

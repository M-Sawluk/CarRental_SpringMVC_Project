package com.michal.carRental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michal.carRental.domain.repository.UserDetailsDao;
import com.michal.carRental.service.UserDetailsDaoService;

@Service
public class JdbcUserDetailsDaoService implements UserDetailsDaoService {

	@Autowired
	private UserDetailsDao userDetailsDao;
	
	
	@Override
	public String findPasswordByUsername(String username) {
		
		return userDetailsDao.findPasswordByUsername(username); 
		

	}


	@Override
	public boolean checkEmail(String email) {
		
		return userDetailsDao.checkEmail(email);
	}
	
	@Override
	public boolean checkUserName(String userName){
		
		return userDetailsDao.checkUserName(userName);
	}

}

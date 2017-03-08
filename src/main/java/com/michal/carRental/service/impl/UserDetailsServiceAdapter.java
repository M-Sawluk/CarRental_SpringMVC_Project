package com.michal.carRental.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.michal.carRental.adapter.UserDetailsAdapter;
import com.michal.carRental.domain.User;
import com.michal.carRental.service.UserDetailsDaoService;

@Service("userDetailsService")
public class UserDetailsServiceAdapter implements UserDetailsService {

	private UserServiceImpl userServiceImpl;

	private UserDetailsDaoService userDetailsDaoService;

	@Autowired
	public UserDetailsServiceAdapter(UserServiceImpl userServiceImpl, UserDetailsDaoService userDetailsDaoService) {
		this.userServiceImpl = userServiceImpl;
		this.userDetailsDaoService = userDetailsDaoService;
	}


	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {

		User user = userServiceImpl.getUserByUserName(userName);
		
		if (user == null) {
			throw new UsernameNotFoundException("No such user: " + userName);
		} else if (user.getRoles().isEmpty()) {
			throw new UsernameNotFoundException("User " + userName + " has no authorities");
		}

		UserDetailsAdapter someOne = new UserDetailsAdapter(user);

		someOne.setPassword(userDetailsDaoService.findPasswordByUsername(userName));

		
		return someOne;
		
	}

}

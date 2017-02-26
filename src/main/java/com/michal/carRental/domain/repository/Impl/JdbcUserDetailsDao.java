package com.michal.carRental.domain.repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import com.michal.carRental.domain.repository.UserDetailsDao;

@Repository
public class JdbcUserDetailsDao implements UserDetailsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String FIND_PASSWORD_SQL = "select password from user where username = ?";

	private static final String FIND_EMAIL_SQL = "select name from user where email = ?";
	
	private static final String FIND_USERNAME_SQL = "select name from user where username = ?";

	public String findPasswordByUsername(String username) {
		return jdbcTemplate.queryForObject(FIND_PASSWORD_SQL, new Object[] { username }, String.class);
	}

	public boolean checkEmail(String email) {

		String test = jdbcTemplate.queryForObject(FIND_EMAIL_SQL, new Object[] { email }, String.class);

	
		if (test == null) {
			return false;
		} else {
			return true;
		}

	}
	
	public boolean checkUserName(String userName) {

		String test = jdbcTemplate.queryForObject(FIND_USERNAME_SQL, new Object[] { userName }, String.class);

	
		if (test == null) {
			return false;
		} else {
			return true;
		}

	}

}

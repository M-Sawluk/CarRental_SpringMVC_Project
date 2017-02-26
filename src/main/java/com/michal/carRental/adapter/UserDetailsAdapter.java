package com.michal.carRental.adapter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.michal.carRental.domain.Role;
import com.michal.carRental.domain.User;
import com.michal.carRental.domain.UserStatus;

public class UserDetailsAdapter implements UserDetails  {


	private static final long serialVersionUID = 6036901725593251440L;
	
	private User user;
	private String password;

	public UserDetailsAdapter(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return user.getId();
	}

	public String getName() {
		return user.getName();
	}

	public String getEmail() {
		return user.getEmail();
	}

	public String getAddress() {
		return user.getAddress();
	}

	public String getTelephone() {
		return user.getTelephone();
	}

	public String getBirth() {
		return user.getBirth();
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		if(user.getStatus()==UserStatus.ACTIVE)
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		for (Role role : user.getRoles()) {
			
			authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
		}

		return authorities;
	}

}

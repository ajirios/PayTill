package com.paytill.PayTill.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.paytill.PayTill.domain.User;

public class AuthenticatedUser extends User implements UserDetails

{
	private static final long serialVersionUID = -1948038667609363629L;
	
	public AuthenticatedUser() {}
	
	public AuthenticatedUser(User user)
	
	{
		this.setUserId(user.getUserId());
		this.setUsername(user.getUsername());
		this.setMobileNumber(user.getMobileNumber());
		this.setEmail(user.getEmail());
		this.setPassword(user.getPassword());
		this.setAuthorities(user.getAuthorities());
	}
	
	@Override
	public boolean isAccountNonExpired() 
	
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	
	{
		return true;
	}

	@Override
	public boolean isEnabled() 
	
	{
		return true;
	}

}

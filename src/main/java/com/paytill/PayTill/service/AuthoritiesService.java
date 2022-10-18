package com.paytill.PayTill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytill.PayTill.domain.Authorities;
import com.paytill.PayTill.domain.User;
import com.paytill.PayTill.repository.AuthoritiesRepository;

@Service
public class AuthoritiesService 

{

	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	@Autowired
	private UserService userService;
	
	public Authorities save(User user)
	
	{
		Authorities authorities = new Authorities();
		authorities.setAuthority("ROLE_USER");
		authorities.setUser(user);
		this.userService.save(user);
		this.authoritiesRepository.save(authorities);
		return authorities;
	}
}

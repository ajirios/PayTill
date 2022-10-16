package com.paytill.PayTill.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paytill.PayTill.domain.User;
import com.paytill.PayTill.repository.UserRepository;
import com.paytill.PayTill.security.AuthenticatedUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService

{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	
	{
		Optional<User> userOptional = this.userRepository.findByUsername(username);
		User user = null;
		
		if (userOptional.isPresent() == true)
			
		{
			user = userOptional.get();
		}
		
		else
			
		{
			throw new UsernameNotFoundException("The username and password do not match.");
		}
		
		return new AuthenticatedUser(user);
	}

}

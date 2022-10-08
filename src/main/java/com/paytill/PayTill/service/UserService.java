package com.paytill.PayTill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytill.PayTill.domain.User;
import com.paytill.PayTill.repository.UserRepository;

@Service
public class UserService 

{
	@Autowired
	private UserRepository userRepository;
	
	public User findById(Long userId)
	
	{
		return this.userRepository.findById(userId).orElse(new User());
	}
	
	public void save(User user)
	
	{
		this.userRepository.save(user);
	}
	
	public void delete(Long userId)
	
	{
		this.userRepository.deleteById(userId);
	}
}

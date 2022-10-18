package com.paytill.PayTill.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.paytill.PayTill.domain.Authorities;
import com.paytill.PayTill.domain.User;
import com.paytill.PayTill.service.AuthoritiesService;
import com.paytill.PayTill.service.UserService;

@Controller
public class RegisterController 

{
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthoritiesService authoritiesService;
	
	@GetMapping("/register")
	public String getRegister(ModelMap modelMap)
	
	{
		modelMap.put("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String postRegister(User user)
	
	{
		user.setCredit(0.00);
		user.setDefaultCurrency("USD");
		
		if (user != null && user.getPassword() != null)
		{
			String crypticPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(crypticPassword);
		}
		
		Authorities authorities = this.authoritiesService.save(user);
		user.getAuthorities().add(authorities);
		this.userService.save(user);
		return "redirect:/";
	}
}

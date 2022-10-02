package com.paytill.PayTill.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController 

{
	@GetMapping("/")
	public String getRoot()
	
	{
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String getLoginPage()
	
	{
		return "login";
	}
	
	@PostMapping("/login")
	public String postLoginPage()
	
	{
		return "redirect:/login";
	}
}

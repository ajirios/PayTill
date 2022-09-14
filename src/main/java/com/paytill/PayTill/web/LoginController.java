package com.paytill.PayTill.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}

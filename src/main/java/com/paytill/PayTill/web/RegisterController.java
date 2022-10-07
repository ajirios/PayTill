package com.paytill.PayTill.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController 

{
	@GetMapping("/register")
	public String getRegister(ModelMap modelMap)
	
	{
		return "register";
	}
	
	@PostMapping("/register")
	public String postRegister(ModelMap modelMap)
	
	{
		return "redirect:/register";
	}
}

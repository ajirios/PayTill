package com.paytill.PayTill.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.paytill.PayTill.domain.User;

@Controller
public class LoginController 

{
	@GetMapping("/")
	public String getRoot()
	
	{
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String getLoginPage(ModelMap modelMap)
	
	{
		modelMap.put("user", new User());
		return "login";
	}
	
	@PostMapping("/login")
	public String postLoginPage(User user)
	
	{
		System.out.println("id is " + user);
		if (user == null || user.getUsername().isBlank() || user.getPassword().isBlank())
			
		{
			return "redirect:/login";
		}
		
		return "redirect:/dashboard";
	}
}

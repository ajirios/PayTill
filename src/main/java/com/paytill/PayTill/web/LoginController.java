package com.paytill.PayTill.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paytill.PayTill.domain.User;

@Controller
public class LoginController 

{
	@GetMapping("")
	public String getRoot(@RequestParam MultiValueMap param)
	
	{
		System.out.println(param);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/login")
	public String getLoginPage(ModelMap modelMap)
	
	{
		//modelMap.put("user", new User());
		return "login";
	}
	
	@PostMapping("/login")
	public String postLoginPage(User user)
	
	{
		System.out.println("id is " + user);
		if (user == null || user.getUsername().isBlank() || user.getPassword().isBlank())
			
		{
			return "redirect:/dashboard";
		}
		
		return "redirect:/dashboard";
	}
}

package com.paytill.PayTill.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paytill.PayTill.service.UserService;

@Controller
public class DashboardController 

{
	@Autowired
	private UserService userService;
	
	@GetMapping("/dashboard")
	public String getDashboard(ModelMap modelMap)
	
	{
		modelMap.put("user", this.userService.findById(Long.valueOf(3)));
		return "dashboard";
	}

	@PostMapping("/dashboard")
	public String postDashboard(ModelMap modelMap, 
			@RequestParam Long userId, 
			@RequestParam Optional<String> username, 
			@RequestParam Optional<String> password)
	
	{
		System.out.println(username.get() + " " + password.get());
		modelMap.put("user", this.userService.findById(userId));
		return "dashboard";
	}
	
}

package com.paytill.PayTill.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.paytill.PayTill.domain.User;
import com.paytill.PayTill.service.UserService;

@Controller
public class RegisterController 

{
	@Autowired
	private UserService userService;
	
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
		this.userService.save(user);
		return "redirect:/dashboard";
	}
}

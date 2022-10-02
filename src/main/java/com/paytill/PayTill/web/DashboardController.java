package com.paytill.PayTill.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController 

{
	
	@GetMapping("/dashboard")
	public String getDashboard(ModelMap modelMap)
	
	{
		return "dashboard";
	}

	@PostMapping("/dashboard")
	public String postDashboard(ModelMap modelMap)
	
	{
		return "redirect:/dashboard";
	}
	
}

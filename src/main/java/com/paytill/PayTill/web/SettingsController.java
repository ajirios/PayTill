package com.paytill.PayTill.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class SettingsController 

{
	@GetMapping("/settings")
	public String getDashboardSettings(ModelMap modelMap)
	
	{
		return "settings";
	}
}

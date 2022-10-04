package com.paytill.PayTill.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChargeController 

{
	
	@GetMapping("/charges")
	public List<String> getCharges()
	
	{
		return null;
	}
	
	@PostMapping("/charges")
	public List<String> postCharges(String body)
	{
		System.out.println(body);
		return null;
	}
	
}

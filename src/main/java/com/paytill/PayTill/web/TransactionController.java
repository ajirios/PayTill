package com.paytill.PayTill.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paytill.PayTill.dto.TransactionDTO;
import com.paytill.PayTill.service.TransactionService;

@RestController
public class TransactionController 

{
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions/add")
	public List<String> getCharges()
	
	{
		return null;
	}
	
	@PostMapping("/transactions/add")
	public Boolean postCharges(@RequestBody TransactionDTO dto)
	
	{
		System.out.println(dto);
		this.transactionService.transfer(dto);
		return true;
	}
}

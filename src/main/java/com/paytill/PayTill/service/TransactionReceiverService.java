package com.paytill.PayTill.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytill.PayTill.domain.User;
import com.paytill.PayTill.dto.TransactionDTO;

@Service
public class TransactionReceiverService 

{
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private UserService userService;
	
	public String attemptTransaction(String textMessage, String phoneNumber)
	
	{
		String message = textMessage.substring(1, textMessage.length() - 1);
		String mobileNumber = phoneNumber.substring(1, phoneNumber.length() - 1);
		String transactionCode = this.getLeadingTransactionCode(textMessage);
		String result = "success";
		
		if (transactionCode != null && transactionCode.equalsIgnoreCase("send"))
		{
			TransactionDTO chargeTransactionDto = getTransaction(message, mobileNumber);
			result = this.transactionService.transfer(chargeTransactionDto);
			
			if (result.contains("successful"))
			{
				TransactionDTO paymentTransactionDto = getTransaction(message);
				String recipientAlert = this.transactionService.transfer(paymentTransactionDto);
			}
		}
		else if (transactionCode != null && transactionCode.equalsIgnoreCase("deposit"))
		{
			TransactionDTO paymentTransactionDto = getTransaction(message, mobileNumber);
			paymentTransactionDto.setType("deposit");
			result = this.transactionService.deposit(paymentTransactionDto);
		}
		
		return result;
	}
	
	public String getLeadingTransactionCode(String textMessage)
	
	{
		if (textMessage.toLowerCase().contains("send") || textMessage.toLowerCase().contains("pay"))
			
		{
			return "send";
		}

		if (textMessage.toLowerCase().contains("deposit") || textMessage.toLowerCase().contains("load"))
			
		{
			return "deposit";
		}
		
		return null;
	}
	
	public Boolean isValidTransaction(String textMessage)
	
	{
		//TO DO
		return true;
	}
	
	private TransactionDTO getTransaction(String textMessage)
	
	{
		TransactionDTO transactionDto = new TransactionDTO();
		transactionDto.setAmount(extractAmount(textMessage));
		transactionDto.setCurrency("USD");
		
		if (textMessage.toLowerCase().contains("send") || textMessage.toLowerCase().contains("pay"))
			
		{
			transactionDto.setType("payment");
			//transactionDto.setUserid(null);
		}

		if (textMessage.toLowerCase().contains("deposit") || textMessage.toLowerCase().contains("load"))
			
		{
			transactionDto.setType("deposit");
		}
		
		transactionDto.setRoute("text");
		transactionDto.setUserid(this.getReceivingUserId(this.extractAccountNumber(textMessage)));
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		transactionDto.setTimestamp(timestamp);
		return transactionDto;
	}
	
	private TransactionDTO getTransaction(String textMessage, String phoneNumber)
	
	{
		TransactionDTO transactionDto = new TransactionDTO();
		transactionDto.setAmount(extractAmount(textMessage));
		transactionDto.setCurrency("USD");
		
		if (textMessage.toLowerCase().contains("send") || textMessage.toLowerCase().contains("pay"))
			
		{
			transactionDto.setType("charge");
			//transactionDto.setUserid(null);
		}

		if (textMessage.toLowerCase().contains("deposit") || textMessage.toLowerCase().contains("load"))
			
		{
			transactionDto.setType("deposit");
		}
		
		transactionDto.setRoute("text");
		transactionDto.setUserid(getUserId(phoneNumber));
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		transactionDto.setTimestamp(timestamp);
		return transactionDto;
	}
	
	private Long getUserId(String phoneNumber)
	
	{
		User user = this.userService.findByMobileNumber(phoneNumber);
		
		if (user != null && user.getUserId() != null)
			
		{
			return user.getUserId();
		}
		
		return null;
	}
	
	private Long getReceivingUserId(Long accountNumber)
	
	{
		Long receivingUserId = 5337543855L - accountNumber;
		return receivingUserId;
	}
	
	private Long extractAmount(String textMessage)
	
	{
		Long amount = 0L;
		String amountString = "";
		double amountDouble = 0.00;
		int amountInteger = 0;
		boolean spaceFound = false;
		boolean numberFound = false;
		
		textMessage += " ";
		
		for (int i = 0; i < textMessage.length() && spaceFound == false; i++)
			
		{
			int asciiCode = textMessage.charAt(i);
			
			if (asciiCode >= 48 && asciiCode <= 57)
				
			{
				numberFound = true;
				amountString += textMessage.charAt(i);
				
				if (textMessage.charAt(i+1) == '.')
				{
					amountString += '.';
				}
				
				if (spaceFound == true && numberFound == true)
				{
					break;
				}
			}
			
			if (textMessage.charAt(i) == ' ' && numberFound == true)
				
			{
				spaceFound = true;
			}
		}
		
		amountString.trim();
		
		if (amountString.length() >= 1)
			
		{
			try
			
			{
				amountDouble = Double.parseDouble(amountString);
			}
			
			catch (Exception ex)
			
			{
				ex.printStackTrace();
			}
		}
		
		amountDouble = Math.ceil(amountDouble * 100);
		amountInteger = (int) amountDouble;
		amount = Long.valueOf(amountInteger);
		return amount;
	}
	
	private Long extractAccountNumber(String textMessage)
	
	{
		Long accountNumber;
		String[] attributes = textMessage.split(" ");
		
		for (String attr : attributes)
		{
			if (attr.contains("#"))
			{
				accountNumber = Long.parseLong(attr.substring(1));
				return accountNumber;
			}
		}
		
		return null;
	}
	
}

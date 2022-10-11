package com.paytill.PayTill.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest 

{
	private String recipientPhoneNumber;
	private String message;
	
	public SmsRequest(@JsonProperty("phoneNumber") String recipientPhoneNumber, @JsonProperty("message") String message)
	
	{
		this.recipientPhoneNumber = recipientPhoneNumber;
		this.message = message;
	}

	public String getRecipientPhoneNumber() 
	
	{
		return recipientPhoneNumber;
	}

	public void setRecipientPhoneNumber(String recipientPhoneNumber) 
	
	{
		this.recipientPhoneNumber = recipientPhoneNumber;
	}

	public String getMessage() 
	
	{
		return message;
	}

	public void setMessage(String message) 
	
	{
		this.message = message;
	}

	@Override
	public String toString() 
	
	{
		return "SmsRequest [recipientPhoneNumber='" + recipientPhoneNumber + "', message='" + message + "']";
	}

}

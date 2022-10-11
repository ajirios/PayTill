package com.paytill.PayTill.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfiguration 

{
	@Value("${twilio.sid}")
	private String twilioSid;
	
	@Value("${twilio.auth.token}")
	private String twilioAuthToken;
	
	@Value("${twilio.service.phoneNumber}")
	private String twilioPhoneNumber;

	public String getTwilioSid() 
	
	{
		return twilioSid;
	}

	public String getTwilioAuthToken() 
	
	{
		return twilioAuthToken;
	}

	public String getTwilioPhoneNumber() 
	
	{
		return twilioPhoneNumber;
	}
	
}

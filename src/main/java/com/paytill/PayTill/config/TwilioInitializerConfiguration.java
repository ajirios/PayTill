package com.paytill.PayTill.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializerConfiguration 

{
	private final TwilioConfiguration twilioConfiguration;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializerConfiguration.class);
	
	@Autowired
	public TwilioInitializerConfiguration(TwilioConfiguration twilioConfiguration)
	
	{
		this.twilioConfiguration = twilioConfiguration;
		Twilio.init(this.twilioConfiguration.getTwilioSid(), this.twilioConfiguration.getTwilioAuthToken());
		LOGGER.info("Twilio initialized with account sid {} ", this.twilioConfiguration.getTwilioSid());
	}
	
}

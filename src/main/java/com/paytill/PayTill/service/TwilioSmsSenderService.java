package com.paytill.PayTill.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytill.PayTill.config.TwilioConfiguration;
import com.paytill.PayTill.dto.SmsRequest;
import com.paytill.PayTill.dto.SmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSmsSenderService implements SmsSender

{
	@Autowired
	private TwilioConfiguration twilioConfiguration;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSenderService.class);

	@Override
	public void sendSms(SmsRequest smsRequest) 
	
	{
		if (isPhoneNumberValid(smsRequest.getRecipientPhoneNumber()))
			
		{
			MessageCreator messageCreator = Message.creator(
					new PhoneNumber(smsRequest.getRecipientPhoneNumber()), 
					new PhoneNumber(this.twilioConfiguration.getTwilioPhoneNumber()), 
					smsRequest.getMessage());
			messageCreator.create();
			LOGGER.info("Send SMS {} " + smsRequest);
		}
		
		else
			
		{
			throw new IllegalArgumentException("Phone number " + smsRequest.getRecipientPhoneNumber() + " is not valid.");
		}
		
	}

	private boolean isPhoneNumberValid(String recipientPhoneNumber) 
	
	{
		// TODO Auto-generated method stub
		return true;
	}

}

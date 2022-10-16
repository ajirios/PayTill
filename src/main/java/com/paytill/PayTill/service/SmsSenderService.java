package com.paytill.PayTill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.paytill.PayTill.dto.SmsRequest;
import com.paytill.PayTill.dto.SmsSender;

@Service
public class SmsSenderService 

{
	@Autowired
	@Qualifier("twilio/sender")
	private SmsSender smsSender;
	
	public void sendSms(SmsRequest smsRequest)
	
	{
		this.smsSender.sendSms(smsRequest);
	}
	
}

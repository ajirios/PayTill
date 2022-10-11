package com.paytill.PayTill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytill.PayTill.dto.SmsRequest;

@Service
public class SmsSenderService 

{
	@Autowired
	private TwilioSmsSenderService twilioSmsSenderService;
	
	public void sendSms(SmsRequest smsRequest)
	
	{
		this.twilioSmsSenderService.sendSms(smsRequest);
	}
	
}

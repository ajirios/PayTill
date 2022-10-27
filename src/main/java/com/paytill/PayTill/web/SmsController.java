package com.paytill.PayTill.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static spark.Spark.post;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;

import com.paytill.PayTill.dto.SmsRequest;
import com.paytill.PayTill.service.SmsSenderService;
import com.paytill.PayTill.service.TransactionReceiverService;

@RestController
@RequestMapping("api/v1/sms")
public class SmsController 

{
	@Autowired
	private SmsSenderService smsSenderService;
	
	@Autowired
	private TransactionReceiverService transactionReceiverService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SmsController.class);
	
	@PostMapping("/send")
	public Boolean postSms(@RequestBody SmsRequest smsRequest)
	
	{
		this.smsSenderService.sendSms(smsRequest);
		return true;
	}
	
	@RequestMapping(value = "/receive", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public String postReceiveSms(@RequestBody MultiValueMap map)
	
	{
		LOGGER.info("keyValuePairs: {}" + map);
		System.out.println(map.get("Body"));
		
		if (map != null && map.get("Body") != null && map.get("From") != null)
			
		{
			String transactionResult = this.transactionReceiverService.attemptTransaction(map.get("Body").toString(), map.get("From").toString());
			
			return transactionResult;
		}
		return "Thanks for replying!";
	}
}

package com.paytill.PayTill.dto;

import java.io.Serializable;

public class TransactionDTO implements Serializable

{
	private String userid;
	private String tracking;
	private String currency;
	private Long amount;
	private String type;
	private String route;
	private String statementdescriptor;
	private String timestamp;
	
	public TransactionDTO()
	
	{
		
	}

	public String getUserid() 
	
	{
		return userid;
	}

	public void setUserid(String userid) 
	
	{
		this.userid = userid;
	}

	public String getTracking() 
	
	{
		return tracking;
	}

	public void setTracking(String tracking) 
	
	{
		this.tracking = tracking;
	}

	public String getCurrency() 
	
	{
		return currency;
	}

	public void setCurrency(String currency) 
	
	{
		this.currency = currency;
	}

	public Long getAmount() 
	
	{
		return amount;
	}

	public void setAmount(Long amount) 
	
	{
		this.amount = amount;
	}

	public String getType() 
	
	{
		return type;
	}

	public void setType(String type) 
	
	{
		this.type = type;
	}

	public String getRoute() 
	
	{
		return route;
	}

	public void setRoute(String route) 
	
	{
		this.route = route;
	}

	public String getStatementdescriptor() 
	
	{
		return statementdescriptor;
	}

	public void setStatementdescriptor(String statementdescriptor) 
	
	{
		this.statementdescriptor = statementdescriptor;
	}

	public String getTimestamp() 
	
	{
		return timestamp;
	}

	public void setTimestamp(String timestamp) 
	
	{
		this.timestamp = timestamp;
	}

	@Override
	public String toString() 
	
	{
		return "TransactionDTO [userid=" + userid + ", tracking=" + tracking + ", currency=" + currency + ", amount="
				+ amount + ", type=" + type + ", route=" + route + ", statementdescriptor=" + statementdescriptor
				+ ", timestamp=" + timestamp + "]";
	}
	
}

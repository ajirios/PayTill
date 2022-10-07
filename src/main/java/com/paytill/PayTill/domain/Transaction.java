package com.paytill.PayTill.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction

{
	private Long transactionId;
	private String tracking;
	private String currency;
	private Double amount;
	private String type;
	private String route;
	private String statementdescriptor;
	private User user;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getTransactionId() 
	
	{
		return transactionId;
	}
	
	public void setTransactionId(Long transactionId) 
	
	{
		this.transactionId = transactionId;
	}
	
	public Double getAmount() 
	
	{
		return amount;
	}
	
	public void setAmount(Double amount) 
	
	{
		this.amount = amount;
	}
	
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() 
	
	{
		return user;
	}
	
	public void setUser(User user) 
	
	{
		this.user = user;
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

	@Override
	public String toString() 
	
	{
		return "Transaction [transactionId=" + transactionId + ", tracking=" + tracking + ", currency=" + currency
				+ ", amount=" + amount + ", type=" + type + ", route=" + route + ", statementdescriptor="
				+ statementdescriptor + ", user=" + user + "]";
	}

	@Override
	public int hashCode() 
	
	{
		return Objects.hash(amount, currency, route, statementdescriptor, tracking, transactionId, type, user);
	}

	@Override
	public boolean equals(Object obj) 
	
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(currency, other.currency)
				&& Objects.equals(route, other.route) && Objects.equals(statementdescriptor, other.statementdescriptor)
				&& Objects.equals(tracking, other.tracking) && Objects.equals(transactionId, other.transactionId)
				&& Objects.equals(type, other.type) && Objects.equals(user, other.user);
	}
	
}

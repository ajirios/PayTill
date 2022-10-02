package com.paytill.PayTill.domain;

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
	private Double amount;
	private String business;
	private String transactionType;
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
	
	public String getBusiness() 
	
	{
		return business;
	}

	public void setBusiness(String business) 
	
	{
		this.business = business;
	}

	public String getTransactionType() 
	
	{
		return transactionType;
	}
	
	public void setTransactionType(String transactionType) 
	
	{
		this.transactionType = transactionType;
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

	@Override
	public int hashCode() 
	
	{
		return Objects.hash(amount, business, transactionId, transactionType, user);
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
		return Objects.equals(amount, other.amount) && Objects.equals(business, other.business)
				&& Objects.equals(transactionId, other.transactionId)
				&& Objects.equals(transactionType, other.transactionType) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() 
	
	{
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", business=" + business
				+ ", transactionType=" + transactionType + ", user=" + user + "]";
	}
	
}

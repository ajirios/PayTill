package com.paytill.PayTill.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authorities implements GrantedAuthority

{
	private static final long serialVersionUID = 2277047643041507260L;
	private Long id;
	private String authority;
	private User user;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() 
	
	{
		return id;
	}

	public void setId(Long id) 
	
	{
		this.id = id;
	}

	@Override
	public String getAuthority() 
	
	{
		return this.authority;
	}

	public void setAuthority(String authority) 
	
	{
		this.authority = authority;
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

}

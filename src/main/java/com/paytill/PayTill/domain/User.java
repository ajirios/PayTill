package com.paytill.PayTill.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable

{
	private static final long serialVersionUID = -3565197518457063604L;
	private Long userId;
	private String username;
	private String title;
	private String name;
	private String firstName;
	private String lastName;
	private String middleName;
	private LocalDate birthDate;
	private String email;
	private String mobileNumber;
	private String password;
	private Double credit;
	private String defaultCurrency;
	private LocalDateTime registrationDate;
	private List<Transaction> transactions = new ArrayList<>();
	private Set<Authorities> authorities = new HashSet<>();
	
	public User() {}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUserId() 
	
	{
		return userId;
	}

	public void setUserId(Long userId) 
	
	{
		this.userId = userId;
	}

	@Column(nullable = false, unique = true, length = 64)
	public String getUsername() 
	
	{
		return username;
	}

	public void setUsername(String username) 
	
	{
		this.username = username;
	}

	@Column(nullable = false, unique = true, length = 64)
	public String getEmail() 
	
	{
		return email;
	}

	public void setEmail(String email) 
	
	{
		this.email = email;
	}

	public String getTitle() 
	
	{
		return title;
	}

	public void setTitle(String title) 
	
	{
		this.title = title;
	}

	public String getName() 
	
	{
		return name;
	}

	public void setName(String name) 
	
	{
		this.name = name;
	}

	public String getFirstName() 
	
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	
	{
		this.lastName = lastName;
	}

	public String getMiddleName() 
	
	{
		return middleName;
	}

	public void setMiddleName(String middleName) 
	
	{
		this.middleName = middleName;
	}

	public LocalDate getBirthDate() 
	
	{
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) 
	
	{
		this.birthDate = birthDate;
	}

	public LocalDateTime getRegistrationDate() 
	
	{
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) 
	
	{
		this.registrationDate = registrationDate;
	}

	public String getMobileNumber() 
	
	{
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) 
	
	{
		this.mobileNumber = mobileNumber;
	}

	@Column(nullable = false, length = 20)
	public String getPassword() 
	
	{
		return password;
	}

	public void setPassword(String password) 
	
	{
		this.password = password;
	}
	
	public Double getCredit() 
	
	{
		return credit;
	}

	public void setCredit(Double credit) 
	
	{
		this.credit = credit;
	}

	public String getDefaultCurrency() 
	
	{
		return defaultCurrency;
	}

	public void setDefaultCurrency(String defaultCurrency) 
	
	{
		this.defaultCurrency = defaultCurrency;
	}

	@OneToMany(mappedBy="user")
	public List<Transaction> getTransactions() 
	
	{
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) 
	
	{
		this.transactions = transactions;
	}

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.MERGE, mappedBy="user")
	public Set<Authorities> getAuthorities() 
	
	{
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) 
	
	{
		this.authorities = authorities;
	}

	@Override
	public int hashCode() 
	
	{
		return Objects.hash(birthDate, email, firstName, lastName, middleName, mobileNumber, name, password,
				registrationDate, title, transactions, userId, username);
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
		User other = (User) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(middleName, other.middleName) && Objects.equals(mobileNumber, other.mobileNumber)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(registrationDate, other.registrationDate) && Objects.equals(title, other.title)
				&& Objects.equals(transactions, other.transactions) && Objects.equals(userId, other.userId)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() 
	
	{
		return "User [userId=" + userId + ", username=" + username + ", title=" + title + ", name=" + name
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", birthDate="
				+ birthDate + ", email=" + email + ", mobileNumber=" + mobileNumber + ", password=" + password
				+ ", credit=" + credit + ", defaultCurrency=" + defaultCurrency + ", registrationDate="
				+ registrationDate + ", transactions=" + transactions + "]";
	}

}

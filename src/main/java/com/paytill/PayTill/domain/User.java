package com.paytill.PayTill.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User 

{
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
	private LocalDateTime registrationDate;
	private List<Transaction> transactions = new ArrayList<>();
	
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

	public String getUsername() 
	
	{
		return username;
	}

	public void setUsername(String username) 
	
	{
		this.username = username;
	}

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

	public String getPassword() 
	
	{
		return password;
	}

	public void setPassword(String password) 
	
	{
		this.password = password;
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
				+ ", registrationDate=" + registrationDate + ", transactions=" + transactions + "]";
	}

}

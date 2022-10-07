package com.paytill.PayTill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytill.PayTill.domain.Transaction;
import com.paytill.PayTill.domain.User;
import com.paytill.PayTill.dto.TransactionDTO;
import com.paytill.PayTill.repository.TransactionRepository;

@Service
public class TransactionService 

{
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private UserService userService;
	
	public Transaction findById(Long transactionId)
	
	{
		return this.transactionRepository.findById(transactionId).orElse(null);
	}
	
	public List<Transaction> findAll()
	
	{
		return this.transactionRepository.findAll();
	}
	
	public List<Transaction> findAllByUserId(Long userId)
	
	{
		return this.transactionRepository.findAll();
	}
	
	public void save(Transaction transaction)
	
	{
		this.transactionRepository.save(transaction);
	}
	
	public void delete(Long transactionId)
	
	{
		this.transactionRepository.deleteById(transactionId);
	}
	
	public void transfer(TransactionDTO transactionDto)
	
	{
		Transaction transaction = new Transaction();
		transaction.setAmount(transactionDto.getAmount() / 100.00);
		transaction.setCurrency(transactionDto.getCurrency());
		transaction.setRoute(transactionDto.getRoute());
		transaction.setStatementdescriptor(transactionDto.getStatementdescriptor());
		transaction.setTracking(transactionDto.getTracking());
		transaction.setType(transactionDto.getType());
		//transaction.setTimestamp(transactionDto.getTimestamp());
		
		User user = new User();
		transaction.setUser(user);
		user.getTransactions().add(transaction);
		this.userService.save(user);
		this.transactionRepository.save(transaction);
	}
	
}

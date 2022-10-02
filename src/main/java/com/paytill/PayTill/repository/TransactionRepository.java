package com.paytill.PayTill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paytill.PayTill.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>

{
	
}

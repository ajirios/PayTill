package com.paytill.PayTill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paytill.PayTill.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>

{
	@Query("select t from Transaction t left join fetch t.user u where u.userId = :userId")
	List<Transaction> findAllByUser(Long userId);
}

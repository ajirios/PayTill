package com.paytill.PayTill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paytill.PayTill.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>

{
	
}

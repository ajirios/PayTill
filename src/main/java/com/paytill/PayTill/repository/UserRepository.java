package com.paytill.PayTill.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paytill.PayTill.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>

{
	@Query("select u from User u left join fetch u.authorities where u.username = :username")
	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmail(String email);

	Optional<User> findByMobileNumber(String phoneNumber);
	
}

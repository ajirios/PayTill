package com.paytill.PayTill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paytill.PayTill.domain.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long>

{
	
}

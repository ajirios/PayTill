package com.paytill.PayTill;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class PayTillApplicationTests {

	@Test
	void contextLoads() 
	
	{
		
	}
	
	@Test
	void should_print_encoded_password()
	
	{
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodingResult = passwordEncoder.encode("password");
		System.out.println(encodingResult);
	}

}

package com.paytill.PayTill;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTests 

{
	@Test
	void should_print_encoded_password()
	
	{
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodingResult = passwordEncoder.encode("password");
		System.out.println(encodingResult);
	}

}

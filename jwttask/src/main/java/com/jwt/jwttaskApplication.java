package com.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class jwttaskApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(jwttaskApplication.class, args);
	}

}

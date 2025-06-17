package com.edu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class B09bSecurityCustomLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(B09bSecurityCustomLoginApplication.class, args);
		
//		String passwd = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234");
//		System.out.println("passwd" + passwd);
	}

}

package com.bookstore;

import com.bookstore.config.SecurityUtility;
import com.bookstore.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreAngularApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(BookstoreAngularApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		User user = new User();
		user.setFirstName("KEVIN");
		user.setLastName("DU");
		user.setUsername("laodu");
		user.setPassword(SecurityUtility.passwordEncoder().encode("123"));
		
	}
}

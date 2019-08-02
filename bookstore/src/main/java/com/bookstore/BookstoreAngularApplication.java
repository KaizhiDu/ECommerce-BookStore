package com.bookstore;

import com.bookstore.config.SecurityUtility;
import com.bookstore.domain.User;
import com.bookstore.domain.security.Role;
import com.bookstore.domain.security.UserRole;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookstoreAngularApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

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
		user.setEmail("123@qq.com");
        Set<UserRole> userRoles = new HashSet<>();
        user.setUserRoles(userRoles);
        Role role = new Role();
        role.setRoleId(1);
        role.setName("ROLE_USER");
        userRoles.add(new UserRole(user, role));
        userService.createUser(user, userRoles);

        userRoles.clear();

        User user2 = new User();
        user2.setFirstName("ADMIN");
        user2.setLastName("ADMIN");
        user2.setUsername("admin");
        user2.setPassword(SecurityUtility.passwordEncoder().encode("123"));
        user2.setEmail("123@qq.com");
        Role role2 = new Role();
        role2.setRoleId(0);
        role2.setName("ROLE_ADMIN");
        userRoles.add(new UserRole(user2, role2));
        userService.createUser(user2, userRoles);
	}
}

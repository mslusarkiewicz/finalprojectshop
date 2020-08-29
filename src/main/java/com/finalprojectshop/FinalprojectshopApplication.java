package com.finalprojectshop;

import com.finalprojectshop.model.User;
import com.finalprojectshop.security.Role;
import com.finalprojectshop.security.UserRole;
import com.finalprojectshop.services.UserService;
import com.finalprojectshop.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class FinalprojectshopApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(FinalprojectshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstName("Paulinka");
        user1.setLastName("Snopapkowska");
        user1.setUsername("P");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("P"));
        user1.setEmail("sdafinalproject@trashmail.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(1);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles);
    }
}
/*
package com.sabrina.librarymanagementsystem.config;

import com.sabrina.librarymanagementsystem.entity.Role;
import com.sabrina.librarymanagementsystem.entity.User;
import com.sabrina.librarymanagementsystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserInitializer(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) {

        if(userRepository.findByEmail("admin@library.com").isEmpty()) {

            User admin = new User();

            admin.setFirstname("Admin");
            admin.setLastname("Library");
            admin.setEmail("admin@library.com");
            admin.setPassword(
                    passwordEncoder.encode("admin123")
            );
            admin.setRole(Role.ADMIN);

            userRepository.save(admin);

            System.out.println("ADMIN created");
        }


        if(userRepository.findByEmail("user@library.com").isEmpty()) {

            User user = new User();

            user.setFirstname("Normal");
            user.setLastname("User");
            user.setEmail("user@library.com");
            user.setPassword(
                    passwordEncoder.encode("user123")
            );
            user.setRole(Role.USER);

            userRepository.save(user);

            System.out.println("USER created");
        }
    }
}*/

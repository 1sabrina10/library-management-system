package com.sabrina.librarymanagementsystem.service;

import com.sabrina.librarymanagementsystem.controller.dto.AuthenticationResponse;
import com.sabrina.librarymanagementsystem.controller.dto.LoginRequest;
import com.sabrina.librarymanagementsystem.controller.dto.RegisterRequest;
import com.sabrina.librarymanagementsystem.entity.Role;
import com.sabrina.librarymanagementsystem.entity.User;
import com.sabrina.librarymanagementsystem.exception.ResourceNotFoundException;
import com.sabrina.librarymanagementsystem.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder,JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthenticationResponse register(RegisterRequest request){
     if(userRepository.existsByEmail(request.getEmail())){
         throw new RuntimeException("Email already exists");
     }
     User user = new User();
     user.setFirstname(request.getFirstname());
     user.setLastname(request.getLastname());
     user.setEmail(request.getEmail());
     user.setPassword(passwordEncoder.encode(request.getPassword()));
     user.setRole(Role.USER);

     userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse().token(token);
   }

    public AuthenticationResponse login(LoginRequest request){

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invalid email or password")
                );

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {

            throw new ResourceNotFoundException("Invalid email or password");
        }

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse().token(token);
    }

}

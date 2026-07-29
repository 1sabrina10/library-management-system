package com.sabrina.librarymanagementsystem.service;

import com.sabrina.librarymanagementsystem.controller.dto.UserResponse;
import com.sabrina.librarymanagementsystem.entity.Role;
import com.sabrina.librarymanagementsystem.entity.User;
import com.sabrina.librarymanagementsystem.exception.ResourceNotFoundException;
import com.sabrina.librarymanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse makeAdmin(Long id){
        User user = userRepository.findById(id)
                   .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setRole(Role.ADMIN);

        userRepository.save(user);

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setFirstname(user.getFirstname());
        response.setLastname(user.getLastname());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());

        return response;
    }
}

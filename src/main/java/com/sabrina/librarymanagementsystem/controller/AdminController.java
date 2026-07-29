package com.sabrina.librarymanagementsystem.controller;

import com.sabrina.librarymanagementsystem.controller.api.AdminApi;
import com.sabrina.librarymanagementsystem.controller.dto.UserResponse;
import com.sabrina.librarymanagementsystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController implements AdminApi {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserResponse> apiAdminUsersIdMakeAdminPut(Long id) {
        return ResponseEntity.ok(userService.makeAdmin(id));
    }
}

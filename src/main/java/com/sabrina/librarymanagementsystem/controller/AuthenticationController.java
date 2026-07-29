package com.sabrina.librarymanagementsystem.controller;

import com.sabrina.librarymanagementsystem.controller.api.AuthenticationApi;
import com.sabrina.librarymanagementsystem.controller.dto.AuthenticationResponse;
import com.sabrina.librarymanagementsystem.controller.dto.LoginRequest;
import com.sabrina.librarymanagementsystem.controller.dto.RegisterRequest;
import com.sabrina.librarymanagementsystem.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController implements AuthenticationApi {

    private AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public ResponseEntity<AuthenticationResponse> apiAuthRegisterPost( @Valid RegisterRequest registerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.register(registerRequest));
    }

    @Override
    public ResponseEntity<AuthenticationResponse> apiAuthLoginPost( @Valid LoginRequest loginRequest) {
      return ResponseEntity.ok(authenticationService.login(loginRequest));
    }


}

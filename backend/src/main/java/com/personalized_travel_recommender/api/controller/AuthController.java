package com.personalized_travel_recommender.api.controller;

import com.personalized_travel_recommender.api.dto.LoginRequest;
import com.personalized_travel_recommender.api.dto.UserDto;
import com.personalized_travel_recommender.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        authService.registerUser(userDto);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        String token = authService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }
}


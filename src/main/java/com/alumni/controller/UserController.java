package com.alumni.controller;

import com.alumni.model.User;
import com.alumni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    // Register
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        try {
            String email = request.get("email");
            String password = request.get("password");

            if (email == null || password == null) {
                return ResponseEntity.badRequest().body("Email and password are required!");
            }

            User user = userService.registerUser(email, password);
            return ResponseEntity.ok("User registered successfully with email: " + user.getEmail());

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Login
    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
    try {
        String email = request.get("email");
        String password = request.get("password");

        if (email == null || password == null) {
            return ResponseEntity.badRequest().body("Email and password are required!");
        }

        User user = userService.loginUser(email, password);
        
        // Return user details as JSON
        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("email", user.getEmail());
        response.put("role", user.getRole());
        response.put("message", "Login successful!");
        
        return ResponseEntity.ok(response);

    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
}
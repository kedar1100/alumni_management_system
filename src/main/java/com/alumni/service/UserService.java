package com.alumni.service;


import com.alumni.model.User;
import com.alumni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String email, String password) {
        // Check if email already exists
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already registered!");
        }

        // Create new user
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // encrypt password
        user.setRole(User.Role.ALUMNI);

        return userRepository.save(user);
    }
}
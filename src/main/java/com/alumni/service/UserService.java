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

    // Register
    public User registerUser(String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already registered!");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(User.Role.ALUMNI);
        return userRepository.save(user);
    }

    // Login
public User loginUser(String email, String password) {
    User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("User not found!"));

    if (!passwordEncoder.matches(password, user.getPassword())) {
        throw new RuntimeException("Invalid password!");
    }

    return user;
}
}
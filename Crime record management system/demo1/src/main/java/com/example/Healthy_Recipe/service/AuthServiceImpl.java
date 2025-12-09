package com.example.Healthy_Recipe.service;

import com.example.Healthy_Recipe.entity.User;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    
    private final UserService userService;
    
    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public User registerUser(String username, String email, String password) {
        if (userService.usernameExists(username)) {
            throw new RuntimeException("Username already exists: " + username);
        }
        
        if (userService.emailExists(email)) {
            throw new RuntimeException("Email already exists: " + email);
        }
        
        User newUser = new User(username, email, password);
        return userService.saveUser(newUser);
    }
    
    @Override
    public User loginUser(String username, String password) {
        Optional<User> userOptional = userService.getUserByUsername(username);
        
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found: " + username);
        }
        
        User user = userOptional.get();
        
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password for user: " + username);
        }
        
        return user;
    }
    
    @Override
    public boolean validateUser(String username, String password) {
        try {
            loginUser(username, password);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
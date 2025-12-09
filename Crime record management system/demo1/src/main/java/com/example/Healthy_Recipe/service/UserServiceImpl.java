package com.example.Healthy_Recipe.service;

import com.example.Healthy_Recipe.entity.User;
import com.example.Healthy_Recipe.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public User updateUser(Long id, User userDetails) {
        User existingUser = getUserById(id);
        
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setHealthGoal(userDetails.getHealthGoal());
        existingUser.setDietaryPreferences(userDetails.getDietaryPreferences());
        
        return userRepository.save(existingUser);
    }
    
    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
    
    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    @Override
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }
    
    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
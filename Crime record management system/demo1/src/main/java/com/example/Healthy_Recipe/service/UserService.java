package com.example.Healthy_Recipe.service;

import com.example.Healthy_Recipe.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);
    boolean usernameExists(String username);
    boolean emailExists(String email);
}
package com.example.Healthy_Recipe.service;

import com.example.Healthy_Recipe.entity.User;

public interface AuthService {
    User registerUser(String username, String email, String password);
    User loginUser(String username, String password);
    boolean validateUser(String username, String password);
}
package com.example.Healthy_Recipe.dto;

import java.time.LocalDateTime;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String healthGoal;
    private String dietaryPreferences;
    private String role;
    private LocalDateTime createdAt;
    
    // Constructors
    public UserDTO() {}
    
    public UserDTO(Long id, String username, String email, String healthGoal, 
                  String dietaryPreferences, String role, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.healthGoal = healthGoal;
        this.dietaryPreferences = dietaryPreferences;
        this.role = role;
        this.createdAt = createdAt;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getHealthGoal() {
        return healthGoal;
    }
    
    public void setHealthGoal(String healthGoal) {
        this.healthGoal = healthGoal;
    }
    
    public String getDietaryPreferences() {
        return dietaryPreferences;
    }
    
    public void setDietaryPreferences(String dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", healthGoal='" + healthGoal + '\'' +
                ", dietaryPreferences='" + dietaryPreferences + '\'' +
                ", role='" + role + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
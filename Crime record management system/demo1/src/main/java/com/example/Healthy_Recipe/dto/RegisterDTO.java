package com.example.Healthy_Recipe.dto;

public class RegisterDTO {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String healthGoal;
    private String dietaryPreferences;
    
    // Constructors
    public RegisterDTO() {}
    
    public RegisterDTO(String username, String email, String password, String confirmPassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    
    // Getters and Setters
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
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getConfirmPassword() {
        return confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
    
    @Override
    public String toString() {
        return "RegisterDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='[PROTECTED]'" +
                ", confirmPassword='[PROTECTED]'" +
                ", healthGoal='" + healthGoal + '\'' +
                ", dietaryPreferences='" + dietaryPreferences + '\'' +
                '}';
    }
}
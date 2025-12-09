package com.example.Healthy_Recipe.controller;

import com.example.Healthy_Recipe.entity.User;
import com.example.Healthy_Recipe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String userProfile(Model model) {
        try {
            // Using userService for some purpose
            boolean serviceAvailable = userService != null;
            
            User demoUser = new User("demoUser", "demo@email.com", "password");
            demoUser.setHealthGoal("Weight Loss");
            demoUser.setDietaryPreferences("Vegetarian");
            model.addAttribute("user", demoUser);
            model.addAttribute("pageTitle", "My Profile");
            model.addAttribute("serviceStatus", serviceAvailable);
        } catch (Exception e) {
            model.addAttribute("error", "Error loading profile: " + e.getMessage());
        }
        return "user-profile";
    }

    @GetMapping("/favorites")
    public String userFavorites(Model model) {
        // Using userService
        boolean serviceAvailable = userService != null;
        model.addAttribute("pageTitle", "My Favorite Recipes");
        model.addAttribute("serviceStatus", serviceAvailable);
        return "user-favorites";
    }
}
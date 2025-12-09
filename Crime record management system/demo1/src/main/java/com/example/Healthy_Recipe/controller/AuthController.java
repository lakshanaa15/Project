package com.example.Healthy_Recipe.controller;

import com.example.Healthy_Recipe.dto.LoginDTO;
import com.example.Healthy_Recipe.dto.RegisterDTO;
import com.example.Healthy_Recipe.entity.User;
import com.example.Healthy_Recipe.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        model.addAttribute("pageTitle", "Login");
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute LoginDTO loginDTO, Model model) {
        try {
            User user = authService.loginUser(loginDTO.getUsername(), loginDTO.getPassword());
            model.addAttribute("success", "Welcome back, " + user.getUsername() + "!");
            return "redirect:/";
            
        } catch (Exception e) {
            model.addAttribute("error", "Login failed: " + e.getMessage());
            model.addAttribute("loginDTO", loginDTO);
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerDTO", new RegisterDTO());
        model.addAttribute("pageTitle", "Register");
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegisterDTO registerDTO, Model model) {
        try {
            if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
                throw new RuntimeException("Passwords do not match");
            }

            User newUser = authService.registerUser(
                registerDTO.getUsername(),
                registerDTO.getEmail(),
                registerDTO.getPassword()
            );
            
            model.addAttribute("success", "Registration successful! Welcome " + newUser.getUsername());
            return "redirect:/login";
            
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            model.addAttribute("registerDTO", registerDTO);
            return "register";
        }
    }
}
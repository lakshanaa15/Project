package com.example.Healthy_Recipe.controller;

import com.example.Healthy_Recipe.entity.Recipe;
import com.example.Healthy_Recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class HomeController {

    private final RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        try {
            List<Recipe> featuredRecipes = recipeService.getTopRatedRecipes();
            List<Recipe> quickRecipes = recipeService.getQuickRecipes(30);
            
            model.addAttribute("featuredRecipes", featuredRecipes);
            model.addAttribute("quickRecipes", quickRecipes);
            model.addAttribute("pageTitle", "Healthy Recipes - Home");
            
        } catch (Exception e) {
            model.addAttribute("error", "Error loading recipes: " + e.getMessage());
        }
        return "index";
    }

    @GetMapping("/search")
    public String searchRecipes(@RequestParam String query, Model model) {
        try {
            List<Recipe> searchResults = recipeService.searchRecipes(query);
            model.addAttribute("recipes", searchResults);
            model.addAttribute("searchQuery", query);
            model.addAttribute("pageTitle", "Search Results for: " + query);
            
        } catch (Exception e) {
            model.addAttribute("error", "Search failed: " + e.getMessage());
        }
        return "recipe-list";
    }
}
package com.example.Healthy_Recipe.controller;

import com.example.Healthy_Recipe.entity.Recipe;
import com.example.Healthy_Recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public String getAllRecipes(Model model) {
        try {
            List<Recipe> recipes = recipeService.getAllRecipes();
            model.addAttribute("recipes", recipes);
            model.addAttribute("pageTitle", "All Recipes");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to load recipes: " + e.getMessage());
        }
        return "recipe-list";
    }

    @GetMapping("/{id}")
    public String getRecipeById(@PathVariable Long id, Model model) {
        try {
            Recipe recipe = recipeService.getRecipeById(id);
            model.addAttribute("recipe", recipe);
            model.addAttribute("pageTitle", recipe.getTitle());
        } catch (Exception e) {
            model.addAttribute("error", "Recipe not found: " + e.getMessage());
            return "redirect:/recipes";
        }
        return "recipe-view";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("pageTitle", "Create New Recipe");
        return "recipe-create";
    }

    @PostMapping("/create")
    public String createRecipe(@ModelAttribute Recipe recipe, Model model) {
        try {
            recipe.setCookingTime(recipe.getCookingTime() != null ? recipe.getCookingTime() : 30);
            recipe.setCalories(recipe.getCalories() != null ? recipe.getCalories() : 200);
            recipe.setDifficulty(recipe.getDifficulty() != null ? recipe.getDifficulty() : "MEDIUM");
            
            Recipe savedRecipe = recipeService.saveRecipe(recipe);
            model.addAttribute("success", "Recipe created successfully!");
            return "redirect:/recipes/" + savedRecipe.getId();
            
        } catch (Exception e) {
            model.addAttribute("error", "Failed to create recipe: " + e.getMessage());
            model.addAttribute("recipe", recipe);
            return "recipe-create";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            Recipe recipe = recipeService.getRecipeById(id);
            model.addAttribute("recipe", recipe);
            model.addAttribute("pageTitle", "Edit: " + recipe.getTitle());
        } catch (Exception e) {
            model.addAttribute("error", "Recipe not found: " + e.getMessage());
            return "redirect:/recipes";
        }
        return "recipe-edit";
    }

    @PostMapping("/edit/{id}")
    public String updateRecipe(@PathVariable Long id, @ModelAttribute Recipe recipeDetails, Model model) {
        try {
            Recipe updatedRecipe = recipeService.updateRecipe(id, recipeDetails);
            model.addAttribute("success", "Recipe updated successfully!");
            return "redirect:/recipes/" + updatedRecipe.getId();
            
        } catch (Exception e) {
            model.addAttribute("error", "Failed to update recipe: " + e.getMessage());
            model.addAttribute("recipe", recipeDetails);
            return "recipe-edit";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable Long id, Model model) {
        try {
            recipeService.deleteRecipe(id);
            model.addAttribute("success", "Recipe deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to delete recipe: " + e.getMessage());
        }
        return "redirect:/recipes";
    }

    @GetMapping("/difficulty/{level}")
    public String getRecipesByDifficulty(@PathVariable String level, Model model) {
        try {
            List<Recipe> recipes = recipeService.getRecipesByDifficulty(level.toUpperCase());
            model.addAttribute("recipes", recipes);
            model.addAttribute("pageTitle", level + " Recipes");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to load recipes: " + e.getMessage());
        }
        return "recipe-list";
    }
}
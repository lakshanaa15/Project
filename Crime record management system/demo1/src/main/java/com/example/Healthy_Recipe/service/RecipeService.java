package com.example.Healthy_Recipe.service;

import com.example.Healthy_Recipe.entity.Recipe;
import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
    Recipe saveRecipe(Recipe recipe);
    Recipe updateRecipe(Long id, Recipe recipeDetails);
    void deleteRecipe(Long id);
    List<Recipe> searchRecipes(String query);
    List<Recipe> getRecipesByDifficulty(String difficulty);
    List<Recipe> getTopRatedRecipes();
    List<Recipe> getQuickRecipes(int maxTime);
}
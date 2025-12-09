package com.example.Healthy_Recipe.service;

import com.example.Healthy_Recipe.entity.Recipe;
import com.example.Healthy_Recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    
    private final RecipeRepository recipeRepository;
    
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    
    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    
    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + id));
    }
    
    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
    
    @Override
    public Recipe updateRecipe(Long id, Recipe recipeDetails) {
        Recipe existingRecipe = getRecipeById(id);
        
        existingRecipe.setTitle(recipeDetails.getTitle());
        existingRecipe.setDescription(recipeDetails.getDescription());
        existingRecipe.setIngredients(recipeDetails.getIngredients());
        existingRecipe.setInstructions(recipeDetails.getInstructions());
        existingRecipe.setCookingTime(recipeDetails.getCookingTime());
        existingRecipe.setCalories(recipeDetails.getCalories());
        existingRecipe.setDifficulty(recipeDetails.getDifficulty());
        existingRecipe.setImageUrl(recipeDetails.getImageUrl());
        
        return recipeRepository.save(existingRecipe);
    }
    
    @Override
    public void deleteRecipe(Long id) {
        Recipe recipe = getRecipeById(id);
        recipeRepository.delete(recipe);
    }
    
    @Override
    public List<Recipe> searchRecipes(String query) {
        return recipeRepository.findByTitleContainingIgnoreCase(query);
    }
    
    @Override
    public List<Recipe> getRecipesByDifficulty(String difficulty) {
        return recipeRepository.findByDifficulty(difficulty);
    }
    
    @Override
    public List<Recipe> getTopRatedRecipes() {
        return recipeRepository.findTopRatedRecipes();
    }
    
    @Override
    public List<Recipe> getQuickRecipes(int maxTime) {
        return recipeRepository.findQuickRecipes(maxTime);
    }
}
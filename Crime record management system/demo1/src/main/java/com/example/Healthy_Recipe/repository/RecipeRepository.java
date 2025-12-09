package com.example.Healthy_Recipe.repository;

import com.example.Healthy_Recipe.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByTitleContainingIgnoreCase(String title);
    List<Recipe> findByDifficulty(String difficulty);
    List<Recipe> findByCreatedByUsername(String username);
    
    @Query("SELECT r FROM Recipe r ORDER BY r.averageRating DESC")
    List<Recipe> findTopRatedRecipes();
    
    @Query("SELECT r FROM Recipe r WHERE r.cookingTime <= :maxTime ORDER BY r.cookingTime ASC")
    List<Recipe> findQuickRecipes(int maxTime);
}
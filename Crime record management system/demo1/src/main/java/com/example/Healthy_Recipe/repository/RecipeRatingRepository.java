package com.example.Healthy_Recipe.repository;

import com.example.Healthy_Recipe.entity.RecipeRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRatingRepository extends JpaRepository<RecipeRating, Long> {
    List<RecipeRating> findByRecipeId(Long recipeId);
    Optional<RecipeRating> findByRecipeIdAndUserId(Long recipeId, Long userId);
    List<RecipeRating> findByUserId(Long userId);
}
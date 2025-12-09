package com.example.Healthy_Recipe.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recipe_ratings")
public class RecipeRating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(nullable = false)
    private Integer rating; // 1-5
    
    @Column(columnDefinition = "TEXT")
    private String reviewText;
    
    private LocalDateTime createdAt;
    
    // Constructors
    public RecipeRating() {
        this.createdAt = LocalDateTime.now();
    }
    
    public RecipeRating(Recipe recipe, User user, Integer rating, String reviewText) {
        this();
        this.recipe = recipe;
        this.user = user;
        this.rating = rating;
        this.reviewText = reviewText;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Recipe getRecipe() {
        return recipe;
    }
    
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Integer getRating() {
        return rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    public String getReviewText() {
        return reviewText;
    }
    
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public String toString() {
        return "RecipeRating{" +
                "id=" + id +
                ", recipe=" + (recipe != null ? recipe.getTitle() : "null") +
                ", user=" + (user != null ? user.getUsername() : "null") +
                ", rating=" + rating +
                ", reviewText='" + reviewText + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
package com.example.Healthy_Recipe.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(length = 1000)
    private String description;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String ingredients;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String instructions;
    
    private Integer cookingTime;
    private Integer calories;
    private String difficulty;
    private String imageUrl;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeRating> ratings = new ArrayList<>();
    
    private Double averageRating = 0.0;
    private LocalDateTime createdAt;

    public Recipe() {
        this.createdAt = LocalDateTime.now();
    }

    public Recipe(String title, String ingredients, String instructions, User createdBy) {
        this();
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.createdBy = createdBy;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    
    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
    
    public Integer getCookingTime() { return cookingTime; }
    public void setCookingTime(Integer cookingTime) { this.cookingTime = cookingTime; }
    
    public Integer getCalories() { return calories; }
    public void setCalories(Integer calories) { this.calories = calories; }
    
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    
    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }
    
    public List<RecipeRating> getRatings() { return ratings; }
    public void setRatings(List<RecipeRating> ratings) { this.ratings = ratings; }
    
    public Double getAverageRating() { return averageRating; }
    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
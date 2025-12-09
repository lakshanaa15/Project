package com.example.Healthy_Recipe.dto;

public class RecipeDTO {
    private Long id;
    private String title;
    private String description;
    private String ingredients;
    private String instructions;
    private Integer cookingTime;
    private Integer calories;
    private String difficulty;
    private String imageUrl;
    private String categoryName;
    private String createdByUsername;
    private Double averageRating;
    
    // Constructors
    public RecipeDTO() {}
    
    public RecipeDTO(Long id, String title, String description, String ingredients, 
                    String instructions, Integer cookingTime, Integer calories, 
                    String difficulty, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
        this.calories = calories;
        this.difficulty = difficulty;
        this.imageUrl = imageUrl;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getIngredients() {
        return ingredients;
    }
    
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    
    public String getInstructions() {
        return instructions;
    }
    
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
    public Integer getCookingTime() {
        return cookingTime;
    }
    
    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }
    
    public Integer getCalories() {
        return calories;
    }
    
    public void setCalories(Integer calories) {
        this.calories = calories;
    }
    
    public String getDifficulty() {
        return difficulty;
    }
    
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public String getCreatedByUsername() {
        return createdByUsername;
    }
    
    public void setCreatedByUsername(String createdByUsername) {
        this.createdByUsername = createdByUsername;
    }
    
    public Double getAverageRating() {
        return averageRating;
    }
    
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
    
    @Override
    public String toString() {
        return "RecipeDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cookingTime=" + cookingTime +
                ", calories=" + calories +
                ", difficulty='" + difficulty + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", createdByUsername='" + createdByUsername + '\'' +
                ", averageRating=" + averageRating +
                '}';
    }
}
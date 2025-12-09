package com.example.Healthy_Recipe.config;

import com.example.Healthy_Recipe.entity.Category;
import com.example.Healthy_Recipe.entity.Recipe;
import com.example.Healthy_Recipe.entity.User;
import com.example.Healthy_Recipe.repository.CategoryRepository;
import com.example.Healthy_Recipe.repository.RecipeRepository;
import com.example.Healthy_Recipe.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;

    public DataLoader(UserRepository userRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🚀 Loading demo data...");

        // Create demo users
        if (userRepository.count() == 0) {
            User admin = new User("admin", "admin@healthyrecipes.com", "admin123");
            admin.setRole(User.UserRole.ADMIN);
            userRepository.save(admin);
            
            User chef = new User("chef_john", "chef@healthyrecipes.com", "chef123");
            chef.setRole(User.UserRole.CHEF);
            chef.setHealthGoal("Weight Maintenance");
            chef.setDietaryPreferences("Mediterranean");
            userRepository.save(chef);
            
            User user = new User("healthy_eater", "user@healthyrecipes.com", "user123");
            user.setHealthGoal("Weight Loss");
            user.setDietaryPreferences("Low-Carb");
            userRepository.save(user);
            
            System.out.println("✅ Demo users created");
        }

        // Create demo categories
        if (categoryRepository.count() == 0) {
            Category breakfast = new Category("Breakfast", "Healthy morning meals to start your day right");
            categoryRepository.save(breakfast);
            
            Category lunch = new Category("Lunch", "Nutritious midday meals for energy");
            categoryRepository.save(lunch);
            
            Category dinner = new Category("Dinner", "Healthy evening meals");
            categoryRepository.save(dinner);
            
            Category snacks = new Category("Snacks", "Healthy between-meal options");
            categoryRepository.save(snacks);
            
            Category desserts = new Category("Desserts", "Guilt-free sweet treats");
            categoryRepository.save(desserts);
            
            System.out.println("✅ Demo categories created");
        }

        // Create demo recipes
        if (recipeRepository.count() == 0) {
            User chef = userRepository.findByUsername("chef_john").orElse(null);
            Category breakfast = categoryRepository.findByName("Breakfast").orElse(null);
            Category lunch = categoryRepository.findByName("Lunch").orElse(null);
            
            if (chef != null && breakfast != null) {
                Recipe recipe1 = new Recipe();
                recipe1.setTitle("Healthy Greek Yogurt Bowl");
                recipe1.setDescription("A protein-packed breakfast bowl with Greek yogurt, fresh fruits, and nuts. Perfect for starting your day with energy and nutrition.");
                recipe1.setIngredients("- 1 cup Greek yogurt\n- 1/2 cup mixed berries\n- 2 tbsp honey\n- 1/4 cup granola\n- 1 tbsp chia seeds\n- 1/4 cup sliced almonds");
                recipe1.setInstructions("1. Spoon Greek yogurt into a bowl\n2. Top with mixed berries\n3. Drizzle with honey\n4. Sprinkle granola, chia seeds, and almonds\n5. Serve immediately");
                recipe1.setCookingTime(5);
                recipe1.setCalories(280);
                recipe1.setDifficulty("EASY");
                recipe1.setCategory(breakfast);
                recipe1.setCreatedBy(chef);
                recipeRepository.save(recipe1);
            }
            
            if (chef != null && lunch != null) {
                Recipe recipe2 = new Recipe();
                recipe2.setTitle("Quinoa Salad with Lemon Dressing");
                recipe2.setDescription("A refreshing and nutritious quinoa salad packed with vegetables and a zesty lemon dressing. Perfect for a light lunch.");
                recipe2.setIngredients("- 1 cup cooked quinoa\n- 1 cucumber, diced\n- 1 cup cherry tomatoes, halved\n- 1/2 red onion, finely chopped\n- 1/4 cup feta cheese\n- 2 tbsp olive oil\n- 1 lemon, juiced\n- Salt and pepper to taste");
                recipe2.setInstructions("1. Cook quinoa according to package instructions\n2. Let quinoa cool completely\n3. Combine quinoa with cucumber, tomatoes, and red onion\n4. Whisk together olive oil, lemon juice, salt, and pepper\n5. Pour dressing over salad and toss gently\n6. Top with feta cheese before serving");
                recipe2.setCookingTime(20);
                recipe2.setCalories(320);
                recipe2.setDifficulty("MEDIUM");
                recipe2.setCategory(lunch);
                recipe2.setCreatedBy(chef);
                recipeRepository.save(recipe2);
            }
            
            System.out.println("✅ Demo recipes created");
        }
        
        System.out.println("🎉 Demo data loading completed!");
    }
}
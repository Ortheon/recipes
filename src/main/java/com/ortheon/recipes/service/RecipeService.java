package com.ortheon.recipes.service;

import com.ortheon.recipes.model.Ingredient;
import com.ortheon.recipes.model.Recipe;
import com.ortheon.recipes.repository.IngredientRepository;
import com.ortheon.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

//    @Autowired
//    private IngredientRepository ingredientRepository;

    public List<Recipe> getAllRecipes() {
        return this.recipeRepository.findAll();
    }

    public Recipe saveRecipe(Recipe recipe) {
        List<Ingredient> ingredients = recipe.getIngredients();
        for (Ingredient ingredient: ingredients) {
            ingredient.setRecipe(recipe);
        }
        recipe.setIngredients(ingredients);
//        recipe.setIngredients(this.ingredientRepository.saveAll(ingredients));
                return this.recipeRepository.save(recipe);
    }
}

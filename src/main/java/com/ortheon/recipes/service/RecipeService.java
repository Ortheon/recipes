package com.ortheon.recipes.service;

import com.ortheon.recipes.model.Ingredient;
import com.ortheon.recipes.model.Recipe;
import com.ortheon.recipes.repository.RecipeRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteRecipe(Long id) {
        this.recipeRepository.deleteById(id);
    }

    public Optional<Recipe> getRecipe(Long id) {
        return this.recipeRepository.findById(id);
    }

    public Recipe updateRecipe(Recipe recipe) {
        Recipe updatedRecipe = this.recipeRepository.findById(recipe.getId()).get();
        updatedRecipe.setIngredients(recipe.getIngredients());
        return this.recipeRepository.save(updatedRecipe);
    };
}

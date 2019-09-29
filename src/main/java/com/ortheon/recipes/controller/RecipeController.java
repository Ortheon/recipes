package com.ortheon.recipes.controller;

import com.ortheon.recipes.model.Recipe;
import com.ortheon.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/recipes")
@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping
    public List<Recipe> getAllRecipes() {
        return this.recipeService.getAllRecipes();
    }
    @PostMapping
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        return  this.recipeService.saveRecipe(recipe);
    }
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        this.recipeService.deleteRecipe(id);
    }
    @GetMapping("/{id}")
    public Optional<Recipe> getRecipe(@PathVariable Long id) {
        return this.recipeService.getRecipe(id);
    }
    @PutMapping()
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
     return this.recipeService.updateRecipe(recipe);
    }

}

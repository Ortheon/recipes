package com.ortheon.recipes.controller;

import com.ortheon.recipes.model.Recipe;
import com.ortheon.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}

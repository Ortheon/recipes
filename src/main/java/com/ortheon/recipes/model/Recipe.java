package com.ortheon.recipes.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    //todo exten dateaudit

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String imagePath;
    private int stars;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Ingredient.class)
    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe() {
    }

    public Recipe(String name, String description, String imagePath, int stars, List<Ingredient> ingredients) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.stars = stars;
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return stars == recipe.stars &&
                id.equals(recipe.id) &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(description, recipe.description) &&
                Objects.equals(imagePath, recipe.imagePath) &&
                Objects.equals(ingredients, recipe.ingredients);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", stars=" + stars +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imagePath, stars, ingredients);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

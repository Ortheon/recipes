package com.ortheon.recipes.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingList {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Ingredient.class)
    private List<Ingredient> ingredients = new ArrayList<>();


    public ShoppingList() {
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

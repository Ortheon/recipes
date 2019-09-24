package com.ortheon.recipes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "ingredients")
@RestResource(exported = false)
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String amountUnit;
    private int amount;
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = true)
    @JsonBackReference
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String name, String amountUnit, int amount, Recipe recipe) {
        this.name = name;
        this.amountUnit = amountUnit;
        this.amount = amount;
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return amount == that.amount &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(amountUnit, that.amountUnit) &&
                Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amountUnit, amount, recipe);
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

    public String getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}

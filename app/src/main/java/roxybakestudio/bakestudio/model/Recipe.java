package roxybakestudio.bakestudio.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Recipe {

    @Expose
    private int recipeId;
    @Expose
    private String name;
    @Expose
    private List<Ingredients> ingredients;
    @Expose
    private List<Steps> steps;
    @Expose
    private int servings;

    public Recipe(int recipeId, String name, List<Ingredients> ingredients,
                  List<Steps> steps, int servings) {
        this.recipeId = recipeId;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.servings = servings;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getName() {
        return name;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public List<Steps> getSteps() {
        return steps;
    }

    public int getServings() {
        return servings;
    }
}

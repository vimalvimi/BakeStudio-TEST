package roxybakestudio.bakestudio.model;

public class Recipe {

    private int recipeId;
    private String name;
    private Ingredients mIngredients;
    private Steps mSteps;
    private int mServings;

    public Recipe(int recipeId, String name, Ingredients ingredients, Steps steps, int servings) {
        this.recipeId = recipeId;
        this.name = name;
        mIngredients = ingredients;
        mSteps = steps;
        mServings = servings;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getName() {
        return name;
    }

    public Ingredients getIngredients() {
        return mIngredients;
    }

    public Steps getSteps() {
        return mSteps;
    }

    public int getServings() {
        return mServings;
    }
}

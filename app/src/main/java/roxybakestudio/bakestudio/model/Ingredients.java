package roxybakestudio.bakestudio.model;

import com.google.gson.annotations.Expose;

public class Ingredients {

    @Expose
    private double quantity;
    @Expose
    private String measure;
    @Expose
    private String ingredient;

    public Ingredients(double quantity, String measure, String ingredient) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public String getIngredient() {
        return ingredient;
    }
}

package roxybakestudio.bakestudio.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import roxybakestudio.bakestudio.model.Recipe;

public interface RecipeService {

    @GET("baking.json")
    Call<List<Recipe>> getAllRecipes();
}

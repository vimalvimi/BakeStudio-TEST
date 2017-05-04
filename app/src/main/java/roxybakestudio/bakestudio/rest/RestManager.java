package roxybakestudio.bakestudio.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import roxybakestudio.bakestudio.helper.Constants;

public class RestManager {

    private RecipeService mRecipeService;

    public RecipeService getRecipeService() {
        if (mRecipeService == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mRecipeService = retrofit.create(RecipeService.class);
        }
        return mRecipeService;
    }


}

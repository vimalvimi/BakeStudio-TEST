package roxybakestudio.bakestudio.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import roxybakestudio.bakestudio.R;
import roxybakestudio.bakestudio.adapter.RecipeAdapter;
import roxybakestudio.bakestudio.model.Recipe;
import roxybakestudio.bakestudio.rest.RestManager;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private RecipeAdapter mRecipeAdapter;
    private RestManager mRestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configViews();

        mRestManager = new RestManager();
        Call<List<Recipe>> listCall = mRestManager.getRecipeService().getAllRecipes();
        listCall.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {

                if (response.isSuccessful()) {
                    List<Recipe> recipes = response.body();

                    for (int i = 0; i < recipes.size(); i++) {
                        Recipe recipe = recipes.get(i);
                        mRecipeAdapter.addRecipe(recipe);
                    }

                } else {
                    Log.d(TAG, "onResponse: RESPONSE CODE ERROR" + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
            }
        });
    }

    private void configViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecipeAdapter = new RecipeAdapter();
        mRecyclerView.setAdapter(mRecipeAdapter);
    }
}

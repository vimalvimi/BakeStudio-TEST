package roxybakestudio.bakestudio.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import roxybakestudio.bakestudio.R;
import roxybakestudio.bakestudio.adapter.RecipeAdapter;
import roxybakestudio.bakestudio.model.Recipe;
import roxybakestudio.bakestudio.rest.RestManager;
import timber.log.Timber;

public class RecipeFragment extends Fragment implements RecipeAdapter.ClickListener {

    private RecyclerView mRecyclerView;
    private RecipeAdapter mRecipeAdapter;
    private RestManager mRestManager;

    boolean mDualPane = false;

    List<Recipe> mRecipes = new ArrayList<>();

    DetailsFragment detailsFragment;

    public RecipeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        ButterKnife.bind(this, view);

        configViews(view);
        mRestManager = new RestManager();
        getFeed();


        if (mDualPane) {
            if (mRecipes != null) {
                detailsFragment = new DetailsFragment();
                detailsFragment.setRecipe(mRecipes.get(0));
            }
        }

        return view;
    }

    private void getFeed() {
        Call<List<Recipe>> listCall = mRestManager.getRecipeService().getAllRecipes();
        listCall.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {

                if (response.isSuccessful()) {
                    List<Recipe> recipes = response.body();
                    mRecipes = recipes;
                    for (int i = 0; i < recipes.size(); i++) {
                        Recipe recipe = recipes.get(i);
                        mRecipeAdapter.addRecipe(recipe);
                    }
                } else {
                    Timber.d("RESPONSE CODE ERROR " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Timber.d(t.getMessage());
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void configViews(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_items);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecipeAdapter = new RecipeAdapter(getActivity());
        mRecipeAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mRecipeAdapter);
        mRecipes = mRecipeAdapter.getRecipes();
    }

    public void setDualPane(boolean dualPane) {
        mDualPane = dualPane;
    }

    @Override
    public void itemClicked(View view, int position) {
        if (mDualPane) {
            Toast.makeText(getActivity(), "HIP HIP", Toast.LENGTH_SHORT).show();
        } else {
            Recipe currentRecipe = mRecipes.get(position);
            detailsFragment.setRecipe(currentRecipe);
        }
    }
}

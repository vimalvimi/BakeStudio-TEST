package roxybakestudio.bakestudio.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import roxybakestudio.bakestudio.R;
import roxybakestudio.bakestudio.adapter.IngredientsAdapter;
import roxybakestudio.bakestudio.adapter.StepsAdapter;
import roxybakestudio.bakestudio.model.Recipe;

public class DetailsFragment extends Fragment {

    //TextView
    @BindView(R.id.d_servings)
    TextView mServings;

    @BindView(R.id.ingredients_header)
    TextView ingredTEST;

    //Adapters
    IngredientsAdapter mIngredientsAdapter;
    StepsAdapter mStepsAdapter;

    Recipe mRecipe;

    public DetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, rootView);

        //Set Ingredients
        setIngredients(rootView);
        mIngredientsAdapter.addIngredient(mRecipe.getIngredients());

        //Set Steps
        setSteps(rootView);
        mStepsAdapter.addSteps(mRecipe.getSteps());

        return rootView;
    }


    private void setIngredients(View view) {
        RecyclerView recyclerViewIngredients
                = (RecyclerView) view.findViewById(R.id.d_ingredients_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewIngredients.setNestedScrollingEnabled(false);

        recyclerViewIngredients.setLayoutManager(layoutManager);
        mIngredientsAdapter = new IngredientsAdapter();
        recyclerViewIngredients.setAdapter(mIngredientsAdapter);
    }

    private void setSteps(View view) {
        RecyclerView recyclerViewSteps
                = (RecyclerView) view.findViewById(R.id.d_steps_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewSteps.setNestedScrollingEnabled(false);

        recyclerViewSteps.setLayoutManager(layoutManager);
        mStepsAdapter = new StepsAdapter();
        recyclerViewSteps.setAdapter(mStepsAdapter);
    }

    public void setRecipe(Recipe recipe) {
            mRecipe = recipe;
    }
}

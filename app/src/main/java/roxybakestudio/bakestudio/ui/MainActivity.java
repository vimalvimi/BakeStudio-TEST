package roxybakestudio.bakestudio.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import roxybakestudio.bakestudio.R;

public class MainActivity extends AppCompatActivity{

    boolean mDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check if the layout is dual
        if (findViewById(R.id.details_fragment) != null) {
            mDualPane = true;

            FragmentManager manager = getSupportFragmentManager();

            RecipeFragment recipeFragment = new RecipeFragment();

            recipeFragment.setDualPane(true);

            manager.beginTransaction()
                    .add(R.id.recipe_fragment, recipeFragment)
                    .commit();

            DetailsFragment detailsFragment = new DetailsFragment();
            manager.beginTransaction()
                    .add(R.id.details_fragment, detailsFragment)
                    .commit();
        } else {
            mDualPane = false;
        }
    }
}
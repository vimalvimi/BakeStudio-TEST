package roxybakestudio.bakestudio.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import roxybakestudio.bakestudio.R;
import roxybakestudio.bakestudio.adapter.RecipeAdapter;
import roxybakestudio.bakestudio.model.Ingredients;
import roxybakestudio.bakestudio.model.Recipe;
import roxybakestudio.bakestudio.model.Steps;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private RecipeAdapter mRecipeAdapter;
    TextView mTextView;
    private ArrayList<Recipe> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.test_text);

        //List
        mData = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_items);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        mRecyclerView.setLayoutManager(layoutManager);
        mRecipeAdapter = new RecipeAdapter(mData, MainActivity.this);
        mRecyclerView.setAdapter(mRecipeAdapter);

    }

    private void setData() {

        mData.add(new Recipe(
                1,
                "Pie0",
                new Ingredients(12, "Cup", "Salt"),
                new Steps(0, "Intro", "New Disc", "www.example.com", "nullhu"),
                23));
        mData.add(new Recipe(
                2,
                "Pie1",
                new Ingredients(32, "Cup", "Salt"),
                new Steps(0, "Intro", "New Disc", "www.example.com", "nullhu"),
                23));
        mData.add(new Recipe(
                2,
                "Pie2",
                new Ingredients(213, "Cup", "Salt"),
                new Steps(0, "Intro", "New Disc", "www.example.com", "nullhu"),
                22));

        mRecipeAdapter.notifyDataSetChanged();
    }
}

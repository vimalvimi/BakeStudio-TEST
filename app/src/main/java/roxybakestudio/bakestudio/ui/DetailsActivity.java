package roxybakestudio.bakestudio.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import roxybakestudio.bakestudio.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        FragmentManager manager = getSupportFragmentManager();

        DetailsFragment detailsFragment = new DetailsFragment();
        manager.beginTransaction()
                .add(R.id.activity_details_container, detailsFragment)
                .commit();
    }
}

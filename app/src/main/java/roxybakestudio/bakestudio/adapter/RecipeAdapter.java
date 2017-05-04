package roxybakestudio.bakestudio.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import roxybakestudio.bakestudio.R;
import roxybakestudio.bakestudio.model.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyViewHolder> {

    private List<Recipe> mRecipes = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView listName, servings;

        public MyViewHolder(View itemView) {
            super(itemView);
            listName = (TextView) itemView.findViewById(R.id.main_recipe_name);
            servings = (TextView) itemView.findViewById(R.id.main_servings);
        }
    }

    public RecipeAdapter() {
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Recipe recipe = mRecipes.get(position);
        holder.listName.setText(recipe.getName());
        holder.servings.setText(String.valueOf(recipe.getServings()));
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public void addRecipe(Recipe recipe) {
        mRecipes.add(recipe);
        notifyDataSetChanged();
    }

}

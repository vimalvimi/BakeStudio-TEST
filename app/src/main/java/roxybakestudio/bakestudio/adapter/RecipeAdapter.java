package roxybakestudio.bakestudio.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import roxybakestudio.bakestudio.R;
import roxybakestudio.bakestudio.model.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyViewHolder> {

    private List<Recipe> mRecipes;
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView listName;

        public MyViewHolder(View itemView) {
            super(itemView);
            listName = (TextView) itemView.findViewById(R.id.recipe_name);
        }
    }

    public RecipeAdapter(List<Recipe> recipes, Context context) {
        mRecipes = recipes;
        mContext = context;
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
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }
}

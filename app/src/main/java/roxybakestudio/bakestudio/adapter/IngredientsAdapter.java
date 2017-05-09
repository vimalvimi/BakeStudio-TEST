package roxybakestudio.bakestudio.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import roxybakestudio.bakestudio.R;
import roxybakestudio.bakestudio.helper.Utils;
import roxybakestudio.bakestudio.model.Ingredients;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.MyViewHolder> {

    private List<Ingredients> mIngredients = new ArrayList<>();

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ingredients, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Ingredients ingredients = mIngredients.get(position);

        holder.ingredient.setText(Utils
                .makeIngredientString(
                        ingredients.getQuantity(),
                        ingredients.getMeasure(),
                        ingredients.getIngredient()));
    }

    @Override
    public int getItemCount() {
        return mIngredients.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ingredient;

        public MyViewHolder(View itemView) {
            super(itemView);
            ingredient = (TextView) itemView.findViewById(R.id.item_ingredient);
        }
    }

    public void addIngredient(List<Ingredients> ingredient) {
        mIngredients = ingredient;
        notifyDataSetChanged();
    }
}

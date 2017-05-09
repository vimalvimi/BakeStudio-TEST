package roxybakestudio.bakestudio.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import roxybakestudio.bakestudio.R;
import roxybakestudio.bakestudio.helper.Utils;
import roxybakestudio.bakestudio.model.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyViewHolder> {

    private List<Recipe> mRecipes = new ArrayList<>();
    private Context mContext;
    private ClickListener mClickListener;

    public RecipeAdapter(Context context) {
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Recipe recipe = mRecipes.get(position);
        holder.mTextView.setText(recipe.getName());
        Glide.with(mContext)
                .load(Utils.getImage(recipe.getName()))
                .crossFade()
                .into(holder.mImageView);
    }

    public void setClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public void addRecipe(Recipe recipe) {
        mRecipes.add(recipe);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTextView;
        ImageView mImageView;

        MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTextView = (TextView) itemView.findViewById(R.id.main_recipe_name);
            mImageView = (ImageView) itemView.findViewById(R.id.main_image);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, "ITEM CLICKED :" + getAdapterPosition(), Toast.LENGTH_SHORT).show();

            if (mClickListener != null) {
                mClickListener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public List<Recipe> getRecipes() {
        return mRecipes;
    }

    public interface ClickListener {
        void itemClicked(View view, int position);
    }
}

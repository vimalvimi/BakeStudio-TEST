package roxybakestudio.bakestudio.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import roxybakestudio.bakestudio.R;
import roxybakestudio.bakestudio.model.Steps;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.MyViewHolder> {

    private List<Steps> mSteps = new ArrayList<>();

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.item_steps, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Steps steps = mSteps.get(position);

        holder.shortDescription.setText(steps.getShortDiscription());
        holder.description.setText(steps.getDescription());
    }

    @Override
    public int getItemCount() {
        return mSteps.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView shortDescription, description;

        MyViewHolder(View itemView) {
            super(itemView);
            shortDescription = (TextView) itemView.findViewById(R.id.step_short_description);
            description = (TextView) itemView.findViewById(R.id.step_description);
        }
    }

    public void addSteps(List<Steps> steps) {
        mSteps = steps;
        notifyDataSetChanged();
    }
}

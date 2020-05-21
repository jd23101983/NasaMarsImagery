package com.deshaies.nasaimagery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.deshaies.nasaimagery.R;
import com.deshaies.nasaimagery.model.Photo;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NasaImageryAdapter extends RecyclerView.Adapter<NasaImageryAdapter.NasaImageViewHolder> {

    private List<Photo> imageResults;
    private ViewGroup theParent;

    public NasaImageryAdapter(List<Photo> imageResults) {
        this.imageResults = imageResults;
    }

    @NonNull
    @Override
    public NasaImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        theParent = parent;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item_layout, parent, false);
        return new NasaImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NasaImageViewHolder holder, int position) {
        Glide.with(theParent.getContext())
                .load(imageResults.get(position).getImgSrc())
                .placeholder(R.drawable.placeholder)
                .into(holder.marsImage);
        holder.roverNameDate.setText(theParent.getContext().getString(R.string.rover_and_date,
                                                            imageResults.get(position).getRover().getName(),
                                                            imageResults.get(position).getEarthDate()));
        holder.roverCamera.setText(imageResults.get(position).getCamera().getFullName());
    }

    @Override
    public int getItemCount() {
        return imageResults != null ? imageResults.size() : 0;
    }

    public void updateData(List<Photo> imageResults) {
        this.imageResults = imageResults;
        notifyDataSetChanged();
    }

    static class NasaImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.mars_image)
        ImageView marsImage;

        @BindView(R.id.rover_name_text_view)
        TextView roverNameDate;

        @BindView(R.id.rover_camera_text_view)
        TextView roverCamera;

        NasaImageViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

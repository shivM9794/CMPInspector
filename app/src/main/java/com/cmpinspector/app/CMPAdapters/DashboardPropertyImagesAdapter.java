package com.cmpinspector.app.CMPAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cmpinspector.app.HomeSection.DashboardPropertyImages;
import com.cmpinspector.app.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DashboardPropertyImagesAdapter extends RecyclerView.Adapter<DashboardPropertyImagesAdapter.DashboardPropertyImagesViewHolder>{

    private List<DashboardPropertyImages> dashboardPropertyImages;

    public DashboardPropertyImagesAdapter(List<DashboardPropertyImages> dashboardPropertyImages) {
        this.dashboardPropertyImages = dashboardPropertyImages;
    }

    @NonNull
    @Override
    public DashboardPropertyImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DashboardPropertyImagesViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_property,parent,false
                )
        );

    }

    @Override
    public void onBindViewHolder(@NonNull DashboardPropertyImagesViewHolder holder, int position) {
        holder.setLocationDate(dashboardPropertyImages.get(position));

    }

    @Override
    public int getItemCount() {
        return dashboardPropertyImages.size();
    }

    static class DashboardPropertyImagesViewHolder extends RecyclerView.ViewHolder{

        private KenBurnsView kbvLocation;
        private TextView textTitle, textLocation, textStarRating;

         DashboardPropertyImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            kbvLocation = itemView.findViewById(R.id.kbvLocation);
            textTitle = itemView.findViewById(R.id.textTitle);
            textLocation = itemView.findViewById(R.id.textLocation);
//            textStarRating = itemView.findViewById(R.id.textStarRating);
        }

        void setLocationDate(DashboardPropertyImages dashboardPropertyImages){
            Picasso.get().load(dashboardPropertyImages.imageUrl).into(kbvLocation);
            textTitle.setText(dashboardPropertyImages.title);
            textLocation.setText(dashboardPropertyImages.location);
//            textStarRating.setText(String.valueOf(dashboardPropertyImages.starRating));

        }
    }
}

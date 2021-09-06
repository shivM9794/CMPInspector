package com.cmpinspector.app.CMPAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cmpinspector.app.HomeSection.BasicDetails1Activity;
import com.cmpinspector.app.ModelResponse.CompleteInspectionData.Image__1;
import com.cmpinspector.app.ModelResponse.CompleteInspectionData.PendInspectedpropertyDatum;
import com.cmpinspector.app.R;
import com.cmpinspector.app.Utility.PreferenceUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PendingListAdapter extends RecyclerView.Adapter<PendingListAdapter.PendingViewHolder> {

    List<PendInspectedpropertyDatum> pendInspectedpropertyData;
//    ArrayList<String> images;
    Context context;
    String BASE_URL = "https://apkconnectlab.com/cmpdtest/";


    public PendingListAdapter(List<PendInspectedpropertyDatum> pendInspectedpropertyData, Context context) {
        this.pendInspectedpropertyData = pendInspectedpropertyData;
        this.context = context;
    }
    @NonNull
    @NotNull
    @Override


    public PendingViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dg,parent,false);
        PendingListAdapter.PendingViewHolder pendingViewHolder = new PendingViewHolder(view);
        return pendingViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull  PendingListAdapter.PendingViewHolder holder, int position) {
        PendInspectedpropertyDatum pendingListHelperClass = pendInspectedpropertyData.get(position);
        if (pendingListHelperClass.getImages()!=null&&!pendingListHelperClass.getImages().isEmpty()){
            Image__1 images = pendingListHelperClass.getImages().get(0);
            String imageUrl = images.getPropertyImage().substring(1);
            Glide.with(context).load(BASE_URL + imageUrl).into(holder.imageView);
        }
//        Glide.with(context).load(BASE_URL + images.get(position)).into(holder.imageView);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BasicDetails1Activity.class);
                intent.putExtra("property_id",String.valueOf(pendingListHelperClass.getPropertyId()));
                PreferenceUtils.setStringValue(context.getApplicationContext(), PreferenceUtils.property_id, String.valueOf(pendingListHelperClass.getPropertyId()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.title.setText(pendingListHelperClass.getPropertyName());
        holder.inspection_date.setText(pendingListHelperClass.getInspectionDate());
        holder.inspection_time.setText(pendingListHelperClass.getInspectionTime());
        holder.pro_id.setText("Property ID #  "+pendingListHelperClass.getPropertySequenceId());
        holder.loc.setText(pendingListHelperClass.getAddress());
        holder.subtitle.setText("Area - "+pendingListHelperClass.getTotalArea()+pendingListHelperClass.getAreaType());
        holder.pending_pro_name.setText("Property Type :"+pendingListHelperClass.getKindOfPropertyName());

    }


    @Override
    public int getItemCount() {

        return pendInspectedpropertyData.size();
    }

    public class PendingViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, imageView2;
        TextView title,subtitle,loc,inspection_date, inspection_time,pro_id,pending_pro_name;
        Button button;
        public PendingViewHolder(@NonNull  View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.pending_img);
            title = itemView.findViewById(R.id.pending_txt1);
            subtitle = itemView.findViewById(R.id.pending_txt2);
            loc = itemView.findViewById(R.id.pending_txt4);
            inspection_date = itemView.findViewById(R.id.pending_txt7);
            inspection_time = itemView.findViewById(R.id.pending_txt8);
            pro_id = itemView.findViewById(R.id.property_id);
            button =itemView.findViewById(R.id.view_details);
            pending_pro_name = itemView.findViewById(R.id.pending_property_type_name);
        }
    }
}

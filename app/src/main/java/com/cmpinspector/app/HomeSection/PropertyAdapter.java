package com.cmpinspector.app.HomeSection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cmpinspector.app.ModelResponse.CompleteInspectionData.ComInspectedpropertyDatum;
import com.cmpinspector.app.ModelResponse.CompleteInspectionData.Image;
import com.cmpinspector.app.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder> {

    List<ComInspectedpropertyDatum> comInspectedpropertyData;
    Context context;
    String BASE_URL = "https://apkconnectlab.com/cmpdtest/";

    public PropertyAdapter(List<ComInspectedpropertyDatum> comInspectedpropertyData, Context context) {
        this.comInspectedpropertyData = comInspectedpropertyData;
        this.context = context;
    }



    @Override
    public PropertyAdapter.PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ci,parent,false);
        PropertyAdapter.PropertyViewHolder propertyViewHolder = new PropertyViewHolder(view);
        return propertyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyAdapter.PropertyViewHolder holder, int position) {
        ComInspectedpropertyDatum propertyHelperClass = comInspectedpropertyData.get(position);
        if (propertyHelperClass.getImages()!=null&&!propertyHelperClass.getImages().isEmpty()){
            Image images = propertyHelperClass.getImages().get(0);
            String imageUrl = images.getPropertyImage().substring(1);
            Glide.with(context).load(BASE_URL + imageUrl).into(holder.imageView);
        }
        holder.t1.setText(propertyHelperClass.getPropertyName());
        holder.prop_ids.setText("Property ID #  "+propertyHelperClass.getPropertySequenceId());
        holder.area1.setText("Area - " +propertyHelperClass.getTotalArea()+  propertyHelperClass.getAreaType());
        holder.t3.setText(propertyHelperClass.getAddress());
        holder.date_comp.setText(propertyHelperClass.getInspectionTime());
        holder.time_comp.setText(propertyHelperClass.getInspectionDate());
        holder.property_type1.setText("Property Type : "+propertyHelperClass.getKindOfPropertyName());

//        For showing verified & reject images in completed inspection list...

       String prop_ver= propertyHelperClass.getPropertyVerified();

        if(prop_ver.equalsIgnoreCase("IR") || prop_ver.equalsIgnoreCase("AR")){
            holder.imageView1.setVisibility(View.VISIBLE);
            holder.imageView1.setImageResource(R.drawable.rejected);
        }
        else if(prop_ver.equalsIgnoreCase("IV") || prop_ver.equalsIgnoreCase("AV")){
            holder.imageView1.setVisibility(View.VISIBLE);
            holder.imageView1.setImageResource(R.drawable.verified);
        }
        else {
            holder.imageView1.setVisibility(View.GONE);
        }





    }

    @Override
    public int getItemCount() {
        return comInspectedpropertyData.size();
    }

    public class PropertyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView,imageView1;
        TextView t1,t2,t3,prop_ids,area1,time_comp,date_comp,property_type1;
        public PropertyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.property_img);
            imageView1 = itemView.findViewById(R.id.verified);
            t1 = itemView.findViewById(R.id.txt1);
            t2 = itemView.findViewById(R.id.txt2);
            t3 = itemView.findViewById(R.id.txt3);
            area1 = itemView.findViewById(R.id.area);
            prop_ids = itemView.findViewById(R.id.property_ids);
            time_comp = itemView.findViewById(R.id.pending_txt7);
            date_comp = itemView.findViewById(R.id.pending_txt8);
            property_type1 = itemView.findViewById(R.id.property_type_name);
        }
    }
}

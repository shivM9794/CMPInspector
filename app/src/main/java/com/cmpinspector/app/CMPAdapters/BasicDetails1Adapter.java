package com.cmpinspector.app.CMPAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cmpinspector.app.HomeSection.BasicDetails_2_SaveActivity;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.KindOfProperty;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.PropertyType;
import com.cmpinspector.app.R;

import java.util.ArrayList;
import java.util.List;

public class BasicDetails1Adapter extends RecyclerView.Adapter<BasicDetails1Adapter.BasicDetailsViewHolder> {

    Context context;
    List<KindOfProperty> kindOfProperties;
    public OnclickListener onclickListener;
    String sub_catid;
    int check_pos= 0;


    public BasicDetails1Adapter(Context context, List<KindOfProperty> kindOfProperties, BasicDetails_2_SaveActivity onclickListener) {
        this.context = context;
        this.onclickListener = onclickListener;
        this.kindOfProperties = kindOfProperties;
    }


    @NonNull
    @Override
    public BasicDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.basic1, parent, false);
        BasicDetails1Adapter.BasicDetailsViewHolder basicDetailsViewHolder = new BasicDetailsViewHolder(view);
        return basicDetailsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BasicDetailsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.button.setText(kindOfProperties.get(position).getCategoryName());
        List<PropertyType> propertyType = kindOfProperties.get(position).getPropertyType();
        if (position == 0) {
            String cat_id = String.valueOf(kindOfProperties.get(position).getCategoryId());
            String name= kindOfProperties.get(position).getCategoryName();
            holder.button.setBackgroundResource(R.drawable.background_input);
            onclickListener.onClick(propertyType, cat_id,name);
        }
        if(check_pos==position){
            String name= kindOfProperties.get(position).getCategoryName();
            holder.button.setBackgroundResource(R.drawable.background_input);
            sub_catid= String.valueOf(kindOfProperties.get(position).getCategoryId());
            onclickListener.onClick(sub_catid);

        }
        else{
            holder.button.setBackgroundResource(R.drawable.textview_bg);
        }
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cat_id = String.valueOf(kindOfProperties.get(position).getCategoryId());
                String name= kindOfProperties.get(position).getCategoryName();
                //  holder.txt_type.setBackgroundResource(R.drawable.rounded_edittext_border);
                onclickListener.onClick(propertyType, cat_id,name);
            }


        });


    }

    @Override
    public int getItemCount() {

        return kindOfProperties.size();
    }

    public interface OnclickListener {

        public void onClick(List<PropertyType> propertyType, String string,String name);

        void onClick(String sub_catid);
    }

    public class BasicDetailsViewHolder extends RecyclerView.ViewHolder {
        TextView button;

        public BasicDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.residental);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    set_selection(getAdapterPosition());
                }
            });
        }
    }
    private void set_selection(int adapterPosition) {
        if(adapterPosition==RecyclerView.NO_POSITION)
            return;

        notifyItemChanged(check_pos);
        check_pos=adapterPosition;
        notifyItemChanged(check_pos);
    }
}






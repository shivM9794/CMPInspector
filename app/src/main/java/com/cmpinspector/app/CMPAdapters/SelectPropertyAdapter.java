package com.cmpinspector.app.CMPAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cmpinspector.app.ModelResponse.StepOneAndTwo.PropertyType;
import com.cmpinspector.app.R;

import java.util.List;

public class SelectPropertyAdapter extends RecyclerView.Adapter<SelectPropertyAdapter.SelectPropertyViewHolder> {

    Context context;
    List<PropertyType> propertyTypes;
    public OnclickListener onclickListener;
    String sub_catid;
    int check_pos= 0;



    public SelectPropertyAdapter(Context context, List<PropertyType> propertyTypes,OnclickListener onclickListener) {
        this.context = context;
        this.propertyTypes = propertyTypes;
        this.onclickListener = onclickListener;
    }

    @NonNull
    @Override
    public SelectPropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_property1,parent,false);
        SelectPropertyAdapter.SelectPropertyViewHolder selectPropertyViewHolder = new SelectPropertyViewHolder(view);
        return selectPropertyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectPropertyViewHolder holder, int position) {
        holder.textView.setText(propertyTypes.get(position).getSubCategoryName());

        if(position==0){
            sub_catid= String.valueOf(propertyTypes.get(position).getSubCategoryId());
            holder.textView.setBackgroundResource(R.drawable.background_input);
            onclickListener.onClick(sub_catid);
        }

        if(check_pos==position){
            holder.textView.setBackgroundResource(R.drawable.background_input);
            sub_catid= String.valueOf(propertyTypes.get(position).getSubCategoryId());
            onclickListener.onClick(sub_catid);

        }
        else{
            holder.textView.setBackgroundResource(R.drawable.textview_bg);
        }
//
//            holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String sub_cat_id= String.valueOf(propertyTypes.get(position).getSubCategoryId());
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return propertyTypes.size();
    }

    public class SelectPropertyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public SelectPropertyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.villa);
            textView.setOnClickListener(new View.OnClickListener() {
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

    public interface OnclickListener{

        public void onClick(String string);

    }
}

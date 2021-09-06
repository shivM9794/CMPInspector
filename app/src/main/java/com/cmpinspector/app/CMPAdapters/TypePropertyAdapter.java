package com.cmpinspector.app.CMPAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cmpinspector.app.ModelResponse.StepOneAndTwo.KindOfProperty;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.PropertyHolder;
import com.cmpinspector.app.R;

import java.util.List;

public class TypePropertyAdapter extends RecyclerView.Adapter<TypePropertyAdapter.TypePropertyViewHolder> {

    Context context;
    List<PropertyHolder> propertyHolders;
    public OnclickListener onclickListener;
    public onClick click;

    public TypePropertyAdapter(Context context, List<PropertyHolder> propertyHolders,OnclickListener onclickListener,onClick click) {
        this.context = context;
        this.propertyHolders = propertyHolders;
        this.onclickListener = onclickListener;
        this.click = click;
    }

    @NonNull
    @Override
    public TypePropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_of_property,parent,false);
        TypePropertyAdapter.TypePropertyViewHolder typePropertyViewHolder = new TypePropertyViewHolder(view);
        return typePropertyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TypePropertyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText((CharSequence) propertyHolders.get(position).getPropertyHolderName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.click(propertyHolders, String.valueOf(propertyHolders.get(position).getPropertyHolderId()),propertyHolders.get(position).getPropertyHolderName());
            }
        });

    }

    @Override
    public int getItemCount() {
        return propertyHolders.size();
    }

    public interface OnclickListener {
    }


    public class TypePropertyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public TypePropertyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.company);

        }
    }
}

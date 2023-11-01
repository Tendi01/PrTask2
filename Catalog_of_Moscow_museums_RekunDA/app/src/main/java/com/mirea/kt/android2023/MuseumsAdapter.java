package com.mirea.kt.android2023;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MuseumsAdapter extends RecyclerView.Adapter<MuseumsAdapter.ViewHolder> {

    private List<Museums> museums;
    private OnMuseumsClickListener onMuseumsClickListener;
    public  MuseumsAdapter(List<Museums> museums, OnMuseumsClickListener onMuseumsClickListener){
        this.museums=museums;
        this.onMuseumsClickListener=onMuseumsClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_museums,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuseumsAdapter.ViewHolder holder, int position) {
        Museums museum = museums.get(position);
        holder.nameView.setText(museum.getName());
        holder.itemView.setOnClickListener(x -> {
                onMuseumsClickListener.onMuseumsClick(museum, holder.getAdapterPosition());
        });
    }
    @Override
    public int getItemCount() {
        return museums.size();
    }

    public interface OnMuseumsClickListener{
        void onMuseumsClick(Museums museums, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        private final ImageView imageView;
       public ViewHolder(@NonNull View itemView){
            super(itemView);
            nameView=itemView.findViewById(R.id.tvMuseumName);
            imageView=itemView.findViewById(R.id.imGim);
        }
    }

}

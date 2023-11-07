package com.mirea.kt.android2023.museumsapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.kt.android2023.museumsapp.model.Museum;
import com.mirea.kt.android2023.museumsapp.R;

import java.util.List;

public class MuseumAdapter extends RecyclerView.Adapter<MuseumAdapter.ViewHolder> {

    private List<Museum> museums;
    private OnBookClickListener onBookClickListener;

    public MuseumAdapter(List<Museum> museums) {
        this.museums = museums;
    }

    public MuseumAdapter(List<Museum> museums, OnBookClickListener onBookClickListener) {
        this.museums = museums;
        this.onBookClickListener = onBookClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_museum, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Museum museum = museums.get(position);

        holder.museumTitle.setText(museum.getName());
        holder.imageViewMuseum.setImageResource(museum.getImagePath());

        holder.itemView.setOnClickListener(x -> {
            onBookClickListener.onMuseumClick(museum, holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return museums.size();
    }

    public interface OnBookClickListener {

        void onMuseumClick(Museum museum, int position);

    }

    public List<Museum> getMuseums() {
        return museums;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView museumTitle;
        private final ImageView imageViewMuseum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            museumTitle = itemView.findViewById(R.id.textViewMuseumTitleItem);
            imageViewMuseum = itemView.findViewById(R.id.imageViewMuseumItem);
        }
    }
}


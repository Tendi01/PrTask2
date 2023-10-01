package com.mirea.kt.android2023;

import android.app.Person;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MuseumsAdapter extends RecyclerView.Adapter<MuseumsAdapter.ViewHolder> {
    private ArrayList<Museums> museums;
    public MuseumsAdapter(ArrayList<Museums> museums) {
        this.museums = museums;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        ViewHolder(View view){
            super(view);
            nameView=view.findViewById(R.id.tvMuseumName);
        }
    }

    @NonNull
    @Override
    public MuseumsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_museums,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuseumsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

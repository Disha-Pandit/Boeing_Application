package com.example.boeingapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boeingapplication.model.KitItem;
import com.example.boeingapplication.R;

import java.util.List;

public class KitAdapter extends RecyclerView.Adapter<KitAdapter.KitViewHolder> {

    private List<KitItem> kitItems;

    public KitAdapter(List<KitItem> kitItems) {
        this.kitItems = kitItems;
    }

    public static class KitViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public KitViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }

        public void bind(KitItem kitItem) {
            imageView.setImageResource(kitItem.getImageResourceId());
            textView.setText(kitItem.getText());
        }
    }

    @NonNull
    @Override
    public KitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kit, parent, false);
        return new KitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KitViewHolder holder, int position) {
        KitItem kitItem = kitItems.get(position);
        holder.bind(kitItem);
    }

    @Override
    public int getItemCount() {
        return kitItems.size();
    }
}
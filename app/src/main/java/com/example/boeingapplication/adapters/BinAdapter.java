package com.example.boeingapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boeingapplication.model.BinItem;
import com.example.boeingapplication.R;

import java.util.List;

public class BinAdapter extends RecyclerView.Adapter<BinAdapter.BinViewHolder> {
    private List<BinItem> binItems;

    public static class BinViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public BinViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    public BinAdapter(List<BinItem> binItems) {

        this.binItems = binItems;
    }



    @NonNull
    @Override
    public BinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bin, parent, false);
        return new BinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BinViewHolder holder, int position) {
        BinItem binItem = binItems.get(position);
        holder.imageView.setImageResource(binItem.getImageResourceId());
        holder.textView.setText(binItem.getText());
    }

    @Override
    public int getItemCount() {
        return binItems.size();
    }
}

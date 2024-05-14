package com.example.boeingapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boeingapplication.model.ChemicalItem;
import com.example.boeingapplication.R;
import com.example.boeingapplication.main_activitys.BinCenters;

import java.util.List;

public class ChemicalAdapter extends RecyclerView.Adapter<ChemicalAdapter.ChemicalViewHolder> {
    private List<ChemicalItem> chemicalItems;
    private Context context;
    public ChemicalAdapter(List<ChemicalItem> chemicalItems,Context context) {
        this.chemicalItems = chemicalItems;
        this.context = context;
    }

    public static class ChemicalViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;


        public ChemicalViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
    @NonNull
    @Override
    public ChemicalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create a new view holder
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chemical, parent, false);
        return new ChemicalViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ChemicalViewHolder holder, int position) {
        // Get the current ChemicalItem
        ChemicalItem chemicalItem = chemicalItems.get(position);

        // Set the image resource and text
        holder.imageView.setImageResource(chemicalItem.getImageResourceId());
        holder.textView.setText(chemicalItem.getText());
        holder.itemView.setOnClickListener(v -> {
            if (chemicalItem.getText().equals("Chemical Details Info")) {

                Intent intent = new Intent(context, BinCenters.class);
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return chemicalItems.size();
    }
}

package com.example.boeingapplication.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boeingapplication.R;
import com.example.boeingapplication.model.SettingItem;

import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.SettingViewHolder>{

    private List<SettingItem> settingItems;

    public static class SettingViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        ImageView imageView1;

        public SettingViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView1);
            imageView1= itemView.findViewById(R.id.imageView1);
        }
    }
    public SettingAdapter(List<SettingItem> settingItems){
        this.settingItems = settingItems;
    }

    @NonNull
    @Override
    public SettingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting, parent, false);
        return new SettingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SettingViewHolder holder, int position) {
        SettingItem settingItem = settingItems.get(position);
        holder.imageView.setImageResource(settingItem.getImageView());
        holder.textView.setText(settingItem.gettext());
        holder.imageView1.setImageResource(settingItem.getImageView1());
//        holder.imageView.setImageResource(settingItems.get(position).getImageView());
//        holder.textView.setText(settingItems.get(position).gettext());
//        holder.imageView.setImageResource(settingItems.get(position).getImageView1());
    }



    @Override
    public int getItemCount() {
        return settingItems.size();
    }


}

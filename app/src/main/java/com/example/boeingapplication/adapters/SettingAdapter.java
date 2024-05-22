package com.example.boeingapplication.adapters;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boeingapplication.main_activitys.ChangePassword;
import com.example.boeingapplication.R;
import com.example.boeingapplication.main_activitys.SelectCustomer;
import com.example.boeingapplication.model.SettingItem;

import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.SettingViewHolder> {

    private List<SettingItem> settingItems;
    private Context context;

    public static class SettingViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        ImageView imageView1;

        public SettingViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView1);
            imageView1 = itemView.findViewById(R.id.imageView1);
        }
    }

    public SettingAdapter(List<SettingItem> settingItems, Context context) {

        this.settingItems = settingItems;
        this.context = context;
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

        if (position == 0) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChangePassword.class);
                    context.startActivity(intent);
                }
            });
        }

        if (position == 2) {
            holder.itemView.setOnClickListener(v -> {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.activity_customer_dialog);
                EditText editTextSearch = dialog.findViewById(R.id.editTextSearch);
                RecyclerView recyclerView = dialog.findViewById(R.id.recyclerViewcustomer);
                ImageView imageViewClear = dialog.findViewById(R.id.imageViewClear);
                TextView done=dialog.findViewById(R.id.buttonDone);
                TextView cancel=dialog.findViewById(R.id.buttonCancel);
                SelectCustomer.initRecyclerView(dialog.getContext(), recyclerView, editTextSearch,done,dialog,cancel);
                editTextSearch.addTextChangedListener(new android.text.TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        imageViewClear.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
                    }
                    @Override
                    public void afterTextChanged(android.text.Editable s) {}
                });
                imageViewClear.setOnClickListener(view -> {
                    editTextSearch.setText("");
                    imageViewClear.setVisibility(View.GONE);
                });
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background);
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(dialog.getWindow().getAttributes());
                layoutParams.width =900 ;
                layoutParams.height = 1400;
                layoutParams.gravity = Gravity.CENTER;
                RecyclerView recyclerView1 = dialog.findViewById(R.id.recyclerViewcustomer);
                EditText searchInput = dialog.findViewById(R.id.editTextSearch);
                SelectCustomer.initRecyclerView(dialog.getContext(), recyclerView1, searchInput,done,dialog,cancel);
                dialog.show();
                dialog.getWindow().setAttributes(layoutParams); // Apply the new attributes
                dialog.setCanceledOnTouchOutside(false);
            });
        }
  }

    @Override
    public int getItemCount() {
        return settingItems.size();
    }
}












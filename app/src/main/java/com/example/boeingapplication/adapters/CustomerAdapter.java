package com.example.boeingapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boeingapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.DialogViewHolder>{
    private List<String> userList;
    private int selectedPosition = -1;
    private List<String> userListFull; // For search filtering
    private Context context;
    private OnUserClickListener onUserClickListener;

    public interface OnUserClickListener {
        void onItemClick(String user, int position);
    }

    public CustomerAdapter(Context context, List<String> userList, OnUserClickListener onUserClickListener) {
        this.context = context;
        this.userList = userList;
        this.userListFull = new ArrayList<>(userList);
        this.onUserClickListener = onUserClickListener;
    }

    @NonNull
    @Override
    public DialogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new DialogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DialogViewHolder holder, int position) {
        String user = userList.get(position);
        holder.textViewUser.setText(user);
        if (position == selectedPosition) {
            holder.imageViewRightMark.setVisibility(View.VISIBLE);
        } else {
            holder.imageViewRightMark.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = holder.getAdapterPosition();
                notifyDataSetChanged();
                if (onUserClickListener != null)
                    onUserClickListener.onItemClick(user, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void filter(String text) {
        userList.clear();
        if (text.isEmpty()) {
            userList.addAll(userListFull);
        } else {
            text = text.toLowerCase();
            for (String user : userListFull) {
                if (user.toLowerCase().contains(text)) {
                    userList.add(user);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class DialogViewHolder extends RecyclerView.ViewHolder {
        public View imageViewRightMark;
        TextView textViewUser;

        public DialogViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewUser = itemView.findViewById(R.id.textViewUser);
            imageViewRightMark = itemView.findViewById(R.id.imageViewRightMark);
        }
    }
}





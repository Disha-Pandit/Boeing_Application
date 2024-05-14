package com.example.boeingapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boeingapplication.model.BinCenter;
import com.example.boeingapplication.R;

import java.util.List;

public class BinCenterAdapter extends RecyclerView.Adapter<BinCenterAdapter.ViewHolder> {

    private List<BinCenter> binCenterList;
    private OnItemClickListener onItemClickListener;

    public BinCenterAdapter(List<BinCenter> binCenterList) {
        this.binCenterList = binCenterList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView binCenterTextView;
        public TextView totalBinsTextView;
        public TextView lastScanDateTextView;

        public ViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            binCenterTextView = itemView.findViewById(R.id.bin_center);
            totalBinsTextView = itemView.findViewById(R.id.total_bins);
            lastScanDateTextView = itemView.findViewById(R.id.last_scan_date);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bin_center_item, parent, false);
        return new ViewHolder(view,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BinCenter binCenter = binCenterList.get(position);
        holder.binCenterTextView.setText(binCenter.getBinCenter());
        holder.totalBinsTextView.setText(binCenter.getTotalBins());
        holder.lastScanDateTextView.setText(binCenter.getLastScanDate());
    }

    @Override
    public int getItemCount() {
        return binCenterList.size();
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}
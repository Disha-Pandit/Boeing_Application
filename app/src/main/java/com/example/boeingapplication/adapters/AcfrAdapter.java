package com.example.boeingapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boeingapplication.model.AcfrItem;
import com.example.boeingapplication.R;

import java.util.List;

public class AcfrAdapter  extends RecyclerView.Adapter<AcfrAdapter.ViewHolder> {
    private List<AcfrItem> dataItemList;

    public AcfrAdapter(List<AcfrItem> dataItemList) {
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_acfr_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AcfrItem dataItem = dataItemList.get(position);

        holder.scanCodeTextView.setText(dataItem.getScanCode());
        holder.partNoTextView.setText(dataItem.getPartNo());
        holder.minMaxAmcTextView.setText(dataItem.getMinMaxAmc());
        holder.shipQtyTextView.setText(dataItem.getShipQty());
        holder.shipDtTextView.setText(dataItem.getShipDt());
        holder.orderQtyTextView.setText(dataItem.getOrderQty());
        holder.orderDtTextView.setText(dataItem.getOrderDt());
        holder.onHandQty1TextView.setText(dataItem.getOnHandQty1());
        holder.onHandQty2TextView.setText(dataItem.getOnHandQty2());
        holder.lastScanDateTextView.setText(dataItem.getLastScanDate());
    }

    @Override
    public int getItemCount() {
        return dataItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView scanCodeTextView;
        TextView partNoTextView;
        TextView minMaxAmcTextView;
        TextView shipQtyTextView;
        TextView shipDtTextView;
        TextView orderQtyTextView;
        TextView orderDtTextView;
        TextView onHandQty1TextView;
        TextView onHandQty2TextView;
        TextView lastScanDateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            scanCodeTextView = itemView.findViewById(R.id.scanCodeTextView);
            partNoTextView = itemView.findViewById(R.id.partnoTextView);
            minMaxAmcTextView = itemView.findViewById(R.id.minMaxAmcTextView);
            shipQtyTextView = itemView.findViewById(R.id.shipQtyTextView);
            shipDtTextView = itemView.findViewById(R.id.shipDtTextView);
            orderQtyTextView = itemView.findViewById(R.id.orderQtyTextView);
            orderDtTextView = itemView.findViewById(R.id.orderDtyTextView);
            onHandQty1TextView = itemView.findViewById(R.id.onhandQty1TextView);
            onHandQty2TextView = itemView.findViewById(R.id.onhandQty2TextView);
            lastScanDateTextView = itemView.findViewById(R.id.lastscanDateTextView);
        }
    }
}
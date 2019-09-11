package com.example.enigma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder> {


    private Context nCtx;
    private List<Delivery> deliveryList;

    public DeliveryAdapter(Context nCtx, List<Delivery> deliveryList) {
        this.nCtx = nCtx;
        this.deliveryList = deliveryList;
    }

    public DeliveryAdapter(DisplayDelivery displayDelivery, List<Delivery> deliveryList) {
    }

    @NonNull
    @Override
    public DeliveryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(nCtx);
        View view = inflater.inflate(R.layout.delivery_list,null);
        DeliveryViewHolder holder = new DeliveryViewHolder(view);
        return new DeliveryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryViewHolder holder, int position) {
        Delivery delivery = deliveryList.get(position);
        /*holder.txtName.setText(delivery.getTitle());
        holder.txtDesc.setText(delivery.getDesc());
        holder.txtQty.setText(delivery.getQuantity());
        holder.txtPrice.setText(String.valueOf(delivery.getPrice()));
        holder.imageView.setImageDrawable(nCtx.getResources().getDrawable(delivery.getImage()));*/
        holder.txtCusName.setText(delivery.getCustomerName());
        holder.txtAddress.setText(delivery.getAddress());
        holder.txtPhone.setText(delivery.getPhone());
        holder.txtID.setText(delivery.getProID());
        holder.txtQty.setText(delivery.getQuantity());
        holder.txtPrice.setText(String.valueOf(delivery.getPrice()));


    }

    @Override
    public int getItemCount() {

         return deliveryList.size();
    }

    class DeliveryViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txtCusName,txtAddress,txtPhone,txtProductName,txtQty,txtPrice,txtID;

        public DeliveryViewHolder(@NonNull View itemView) {

            super(itemView);
            //imageView = itemView.findViewById(R.id.imageView);

            txtCusName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            txtID = itemView.findViewById(R.id.txtID);
            txtProductName = itemView.findViewById(R.id.txtProductID);
            txtQty = itemView.findViewById(R.id.txtQty);
            txtPrice = itemView.findViewById(R.id.txtPrice);

        }
    }

}

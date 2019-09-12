package com.example.enigma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.cartViewHolder>{

    private Context mCtx;
    private List<cart> cartList;

    public cartAdapter(Context mCtx, List<cart> cartList) {
        this.mCtx = mCtx;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cart_layout, null);
        return new cartViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull cartViewHolder holder, int position) {
       // CartMain cartMain = cartList.get(position);
        //CartMain cartMain = cartList.get(position);

        //holder.editText1.setText(cartMain.getCustomerName());
        //holder.editText2.setText(cartMain.getQuantity());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class cartViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        EditText editText1,editText2;

        public cartViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.txtimage);
            editText1 = itemView.findViewById(R.id.txtcusName);
            editText2 = itemView.findViewById(R.id.txtqty);

        }
    }
}

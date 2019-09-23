package com.example.enigma;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapterhome extends RecyclerView.Adapter<ProductAdapterhome.productViewHolder> {

    private Context mCtx;
    List<Product> productList;

 public ProductAdapterhome(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

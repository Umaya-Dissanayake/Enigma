package com.example.enigma;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DisplayDelivery extends Fragment {

    View v;
    RecyclerView recyclerView;
    DeliveryAdapter deliveryAdapter;
    List<Delivery> deliveryList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        v = inflater.inflate(R.layout.fragment_delivery_view,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycletView);
        DeliveryAdapter recycleAdapterDel = new DeliveryAdapter(getContext(),deliveryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleAdapterDel);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        deliveryList = new ArrayList<>();
        //deliveryList.add(new Delivery(1,"Name1","desc",220.0,3,));
        deliveryList.add(new Delivery("CusName","address","0774589622",2,2,300.0));
        deliveryList.add(new Delivery("CusName1","address1","0774589671",4,1,350.0));
        deliveryList.add(new Delivery("CusName2","address2","0774589627",1,2,325.0));
        deliveryList.add(new Delivery("CusName3","address3","0774589624",8,3,250.0));
        deliveryList.add(new Delivery("CusName4","address4","0774589628",3,4,200.0));

        deliveryAdapter = new DeliveryAdapter(this,deliveryList);
        recyclerView.setAdapter(deliveryAdapter);


    }
}

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

public class FragmentDelivery extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<Delivery> deliveryList;

    public FragmentDelivery(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_delivery_view,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycletView);
        DeliveryViewAdapter delAdapter = new DeliveryViewAdapter(getContext(),deliveryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(delAdapter);
        return  v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        deliveryList =  new ArrayList<>();
        deliveryList.add(new Delivery("Customer1","Address1","0774859655",3,2,300.00));
        deliveryList.add(new Delivery("Customer2","Address2","0774859655",3,2,300.00));
        deliveryList.add(new Delivery("Customer3","Address3","0774859655",3,2,300.00));
        deliveryList.add(new Delivery("Customer4","Address4","0774859655",3,2,300.00));
        deliveryList.add(new Delivery("Customer5","Address5","0774859655",3,2,300.00));

    }


}

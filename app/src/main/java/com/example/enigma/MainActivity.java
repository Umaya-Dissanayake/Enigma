package com.example.enigma;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DatabaseHelperProduct mydb;

    RecyclerView recyclerView;
    ProductAdapterhome adapterhome;

    List<Product> productList;

    Button btnDelivery;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        productList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mydb = new DatabaseHelperProduct(this);

        EditText search  = findViewById(R.id.searchtxt);
        search.addTextChangedListener(new TextWatcher() {

 @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        Cursor res =  mydb.getAllData();

        if(res.getCount() == 0){
            //show message

            return;
        }


        while(res.moveToNext()) {
            int id = Integer.parseInt(res.getString(0));
            String name =res.getString(1);
            String des = res.getString(2);
            double rate =Double.parseDouble(res.getString(3));
            double price =Integer.parseInt(res.getString(4));



            productList.add(new Product(id, name, des, rate, price, R.drawable.bg));
        }


        adapterhome = new ProductAdapterhome(this, productList);
        recyclerView.setAdapter(adapterhome);




        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

//        DeliveryIntent();

 private void filter(String text){
        ArrayList<Product> filteredList = new ArrayList<>();

        for(Product item : productList){
            if(item.getTitle().toLowerCase().contains(text.toLowerCase() )){
                filteredList.add(item);
            }
        }
        adapterhome.filterList(filteredList);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





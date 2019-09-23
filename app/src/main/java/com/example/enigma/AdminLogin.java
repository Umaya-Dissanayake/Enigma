package com.example.enigma;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends Fragment {


    EditText txtp,txtu;
    View v;
    Button btnadminfr;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_admin_login, container, false);
        Button btnadminfr = (Button)view.findViewById(R.id.btn_loginadmin);
        txtu= view.findViewById(R.id.et_email);
        txtp= view.findViewById(R.id.et_password);


        btnadminfr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String AdminU = txtu.getText().toString();
                String AdminP = txtp.getText().toString();

                if(AdminU.length() != 0){

                    if(AdminP.length() != 0){

                        if(AdminU.equals("Admin") && AdminP.equals("123")){
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.screen_area,new panel());
                            ft.commit();}

                        else{
                            Toast.makeText(getActivity(), "Incorrect Username And Password ",Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(getActivity(), "Insert Password",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Insert Username",Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }

}
package com.example.enigma;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.InputMismatchException;


public class productadd_update extends Fragment {

    EditText txtname,txttitle,txtrating,txtprice;
    Button btninsert, btnclear;
    View v;
    DatabaseHelperProduct db;
    String examCenterValue;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_productadd_update, container, false);

        txtname =v.findViewById(R.id.txtName);
        txttitle = v.findViewById(R.id.txtDesc);
        txtrating = v.findViewById(R.id.txtRate);
        txtprice = v.findViewById(R.id.txtPrice);

        btninsert = v.findViewById(R.id.btnInsert);
        btnclear = v.findViewById(R.id.btnClear);
        db = new DatabaseHelperProduct(this.getActivity());


        ////////////////////////////////////////////////////////


        //////////////////////////////////////////////////////////////////////////////////


        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String productname = txtname.getText().toString();
                String producttitle = txttitle.getText().toString();
                String productrating = txtrating.getText().toString();
                String productprice = txtprice.getText().toString();





                if(productname.length() != 0){

                    if(producttitle.length() != 0){

                        if(productrating.length() != 0){

                            if(productprice.length() != 0){

                            try{


                                Product dto = new Product();
                                dto.setTitle(productname);
                                dto.setPrice(Double.parseDouble(productprice));
                                dto.setRating(Double.parseDouble(productrating));
                                dto.setShortdesc(producttitle);



                                boolean i = db.addInfo(dto);

                                if(i){

                                    Toast.makeText(getActivity(), "Product Added Successfully",Toast.LENGTH_LONG).show();
                                    txtname.setText(" ");
                                    txttitle.setText(" ");
                                    txtrating.setText(" ");
                                    txtprice.setText(" ");

                                }else{

                                    Toast.makeText(getActivity(), "Fail to Add Product",Toast.LENGTH_LONG).show();

                                }

                            }catch (InputMismatchException s){

                                Toast.makeText(getActivity(), "Invalid Type",Toast.LENGTH_LONG).show();

                            }catch (NumberFormatException s){

                                Toast.makeText(getActivity(), "Invalid rating",Toast.LENGTH_LONG).show();


                            }

                        }else{

                                Toast.makeText(getActivity(), "Insert title",Toast.LENGTH_LONG).show();


                            }

                    }else{

                            Toast.makeText(getActivity(), "Insert name",Toast.LENGTH_LONG).show();


                        }
                }else {

                        Toast.makeText(getActivity(), "Insert rating",Toast.LENGTH_LONG).show();


                    }
                }else{

                    Toast.makeText(getActivity(), "Insert price",Toast.LENGTH_LONG).show();



                }



            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtname.setText(" ");
                txttitle.setText(" ");
                txtrating.setText(" ");
                txtprice.setText(" ");

            }
        });




        return v;


    }






}


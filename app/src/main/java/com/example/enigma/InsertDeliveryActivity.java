package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InsertDeliveryActivity extends AppCompatActivity {

    Button btnAddDelivery;
    TextView proID, proName, cusName, address, qty, price;
    public DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_delivery);

        dbHelper = new DBHelper(this);

        proID = (TextView)findViewById(R.id.txtID);
        proName = (TextView)findViewById(R.id.txtProName);
        cusName = (TextView)findViewById(R.id.txtName);
        address = (TextView)findViewById(R.id.txtAddress);
        qty = (TextView)findViewById(R.id.txtQty);
        price = (TextView)findViewById(R.id.txtPrice);



        btnAddDelivery = findViewById(R.id.btnAddDelivery);

        btnAddDelivery.setOnClickListener(new View.OnClickListener() {


//            int  i = Integer.parseInt(proID.getText().toString().trim());
//            int j = Integer.parseInt(qty.getText().toString().trim());
//            double k = Double.parseDouble(price.getText().toString().trim());

            @Override
            public void onClick(View view) {

                String id = proID.getText().toString();
                String qty1 = qty.getText().toString();
                String price1 = price.getText().toString();
                String name = proName.getText().toString();
                String add = address.getText().toString();
                String fname = cusName.getText().toString();

                int  i = Integer.parseInt(id);
                int j = Integer.parseInt(qty1);
                int k = Integer.parseInt(price1);

                System.out.println("FFFFFFFFFf"+i);
                System.out.println("FFFFFFFFFf"+j);
                System.out.println("FFFFFFFFFf"+k);
                System.out.println("FFFFFFFFFf"+name);
                System.out.println("FFFFFFFFFf"+add);
                System.out.println("FFFFFFFFFf"+fname);
//                System.out.println("JJJJJJJ"+);
//                System.out.println("JJJJJJJ"+qty.getText().toString());
//                System.out.println("JJJJJJJ"+price.getText().toString());
//                System.out.println("JJJJ"+i);
//                System.out.println("JJJJ"+j);
//                System.out.println("JJJJ"+k);


             long l = dbHelper.addDelivery(i,name,fname,add,j,k);
                dbHelper.addDelivery(Integer.valueOf(proID.getText().toString()),
                        proName.getText().toString(),
                        cusName.getText().toString(),
                        address.getText().toString(),
                        Integer.valueOf(qty.getText().toString()),
                        Double.valueOf(price.getText().toString()));
                Toast.makeText(getApplicationContext(),"Delivery Added Succssfully",Toast.LENGTH_LONG).show();
            }
        });


    }
}

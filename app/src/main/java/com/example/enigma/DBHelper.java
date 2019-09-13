package com.example.enigma;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Enigma.db";
    public static final String TABLE_NAME = "Deliveries";

    public static final String COLUMN_NAME_PROID = "productID" ;
    public static final String COLUMN_NAME_PRONAME = "productName";
    public static final String COLUMN_NAME_CUSNAME = "cusName";
    public static final String COLUMN_NAME_ADDRESS = "address";
    public static final String COLUMN_NAME_QUANTITY = "qty";
    public static final String COLUMN_NAME_PRICE = "price";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_ENTRIES =
                " CREATE TABLE " + TABLE_NAME + " ( " +
                COLUMN_NAME_PROID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME_PRONAME + " TEXT, " +
                COLUMN_NAME_CUSNAME + " TEXT, " +
                COLUMN_NAME_ADDRESS + " TEXT, " +
                COLUMN_NAME_QUANTITY + " INTEGER, " +
                COLUMN_NAME_PRICE + " REAL) ";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addDelivery(int proID, String proName,String cusName, String address, int qty, double price ){

        SQLiteDatabase db = getWritableDatabase();

        System.out.println("JJJJJJJJJJJJJJJJJJJJJJJJJJJ");
        System.out.println( proID);
        System.out.println( proName);
        System.out.println( cusName);
        System.out.println( address);
        System.out.println( qty);
        System.out.println( price);


        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_PROID,proID);
        values.put(COLUMN_NAME_PRONAME,proName);
        values.put(COLUMN_NAME_CUSNAME,cusName);
        values.put(COLUMN_NAME_ADDRESS,address);
        values.put(COLUMN_NAME_QUANTITY,qty);
        values.put(COLUMN_NAME_PRICE,price);



        //long newRowId = db.insert(TABLE_NAME,null,values);
return 0;
       // return newRowId;
    }
}

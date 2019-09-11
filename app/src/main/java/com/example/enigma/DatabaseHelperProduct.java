package com.example.enigma;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperProduct extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "product1.db";
    public static final String TABLE_NAME = "product_table";
    public static final String Col_Id = "ID";
    public static final String Col_name = "Name";
    public static final String Col_title = "Title";
    public static final String Col_rating = "Rating";
    public static final String Col_price = "Price";


    public DatabaseHelperProduct(Context context) {
        super(context, DATABASE_NAME, null, 1);
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Title text,Rating DOUBLE,Price DOUBLE )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean addInfo(Product obj){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelperProduct.Col_name,obj.getTitle());
        values.put(DatabaseHelperProduct.Col_title,obj.getShortdesc());
        values.put(DatabaseHelperProduct.Col_rating,obj.getRating());
        values.put(DatabaseHelperProduct.Col_price,obj.getPrice());

        long result =  db.insert(TABLE_NAME,null,values);

        if(result>0){
            return true;

        }else{
            return false;
        }

    }

    public Cursor getAllData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return res;


    }

}

package com.example.homeserviceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "home099.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table maidservice(name TEXT,phno Text primary key,rating Text,amount Text)");
        sqLiteDatabase.execSQL("create Table cleaningservice(name TEXT,phno Text primary key,rating Text,amount Text)");
        sqLiteDatabase.execSQL("create Table plumberservice(name TEXT,phno Text primary key,rating Text,amount Text)");


        sqLiteDatabase.execSQL("create Table users(username TEXT primary key,password TEXT)");
        sqLiteDatabase.execSQL("create Table electricianservice(name TEXT,phno Text primary key,rating Text,amount Text)");
        sqLiteDatabase.execSQL("create Table paintingservice(name TEXT,phno Text primary key,rating Text,amount Text)");
        sqLiteDatabase.execSQL("create Table mechanicservice(name TEXT,phno Text primary key,rating Text,amount Text)");
        sqLiteDatabase.execSQL("create Table BookingDetails (Types_Of_service Text,service_provider_name Text,Service_Provider_Number Text,Servicer_Amount Text,Schedule_Time Text,Schedule_Date Text,user_details Text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists maidservice");
        sqLiteDatabase.execSQL("drop Table if exists cleaningservice ");
        sqLiteDatabase.execSQL("drop Table if exists plumberservice ");
        sqLiteDatabase.execSQL("drop Table if exists mechanicservice");
        sqLiteDatabase.execSQL("drop Table if exists electricianservice");
        sqLiteDatabase.execSQL("drop Table if exists paintingservice");
        sqLiteDatabase.execSQL("drop Table if exists mechanicservice");
        sqLiteDatabase.execSQL("drop Table if exists BookingDetails");



        sqLiteDatabase.execSQL("drop Table if exists users");
    }
    public Boolean userdata(String username,String password){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=sqLiteDatabase.insert("users",null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else {
            return  true;
        }
    }
    public Boolean checkusername(String username){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from users where username=?",new String[] {username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
            return false;

    }
    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from users where username=? and password=?",new String[] {username,password});
        if(cursor.getCount()>0)
        return true;
        else
            return false;
    }

    public Boolean insertuserdata(String name, String phno, String rating,String amount) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phno", phno);
        contentValues.put("rating", rating);
        contentValues.put("amount",amount);
        long result = sqLiteDatabase.insert("maidservice", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getdata() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from maidservice", null);
        return cursor;
    }

    public Boolean insertuserdata1(String name, String phno, String rating, String amount) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phno", phno);
        contentValues.put("rating", rating);
        contentValues.put("amount",amount);
        long result = sqLiteDatabase.insert("cleaningservice", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getdata1() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from cleaningservice", null);
        return cursor;

    }
    public Boolean insertuserdata2(String name, String phno, String rating, String amount) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phno", phno);
        contentValues.put("rating", rating);
        contentValues.put("amount",amount);
        long result = sqLiteDatabase.insert("plumberservice", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getdata2() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from plumberservice", null);
        return cursor;

    }
    public Boolean insertuserdata3(String name, String phno, String rating,String amount) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phno", phno);
        contentValues.put("rating", rating);
        contentValues.put("amount",amount);
        long result = sqLiteDatabase.insert("electricianservice", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getdata3() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from electricianservice", null);
        return cursor;

    }
    public Boolean insertuserdata4(String name, String phno, String rating, String amount) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phno", phno);
        contentValues.put("rating", rating);
        contentValues.put("amount",amount);
        long result = sqLiteDatabase.insert("paintingservice", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getdata4() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from paintingservice", null);
        return cursor;

    }
    public Boolean insertuserdata5(String name, String phno, String rating,String amount) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phno", phno);
        contentValues.put("rating", rating);
        contentValues.put("amount",amount);
        long result = sqLiteDatabase.insert("mechanicservice", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getdata5() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from mechanicservice", null);
        return cursor;

    }
    public Boolean insertBookingdata(String Types_Of_service ,String service_provider_name , String Service_Provider_Number,String Servicer_Amount,String Schedule_Time,String Schedule_Date ,String user_details ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        boolean checkState=check(service_provider_name,Schedule_Time,Schedule_Date);
        if(checkState==true) {
            contentValues.put("Types_Of_service", Types_Of_service);
            contentValues.put("service_provider_name", service_provider_name);
            contentValues.put("Service_Provider_Number", Service_Provider_Number);
            contentValues.put("Servicer_Amount", Servicer_Amount);
            contentValues.put("Schedule_Time", Schedule_Time);
            contentValues.put("Schedule_Date", Schedule_Date);
            contentValues.put("user_details", user_details);

            long result = sqLiteDatabase.insert("BookingDetails", null, contentValues);
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else{
            return false;
        }
    }

    private boolean check(String name,String time,String date) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int result=0;
        try {
            Cursor cursor = sqLiteDatabase.rawQuery("Select service_provider_name,Schedule_Time,Schedule_Date from BookingDetails where service_provider_name=?", new String[]{name});
            while (cursor.moveToNext()) {
                System.out.println("hellllllllloooooo");
                if (cursor.getString(0).equals(name) && cursor.getString(2).equals(date)) {
                    if (cursor.getString(1).equals(time)) {
                        System.out.println("gdsfhgjkwdhcjkles");
                        result++;
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(result>0){
            return false;
        }
        else{
            return true;
        }
    }
}

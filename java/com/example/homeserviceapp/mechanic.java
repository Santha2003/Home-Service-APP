package com.example.homeserviceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class mechanic extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> name, phno, rating,amount;
    DBHelper DB;
    mechanic_Adaptor adaptor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic);

        DB = new DBHelper(this);
        name = new ArrayList<>();
        phno = new ArrayList<>();
        rating = new ArrayList<>();
        amount=new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adaptor = new mechanic_Adaptor(this, name, phno, rating,amount);
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = DB.getdata5();
        if (cursor.getCount() == 0) {
            Toast.makeText(mechanic.this, "NO Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                name.add(cursor.getString(0));
                phno.add(cursor.getString(1));
                rating.add(cursor.getString(2));
                amount.add(cursor.getString(3));
//
//
            }

        }


    }
}
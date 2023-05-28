package com.example.homeserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class plumber_service extends AppCompatActivity {

    EditText name,phno,rating,amount;
    Button insert,view;
    DBHelper DB;
    @SuppressLint({"MissingInflatedId", "RestrictedApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber_service);


        name=findViewById(R.id.name);
        phno=findViewById(R.id.phno);
        rating=findViewById(R.id.rating);
        amount=findViewById(R.id.amount);
        insert=findViewById(R.id.btninsert);
        view=findViewById(R.id.btnview);
        DB=new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                    Log.d("new","Hello");
                startActivity(new Intent(plumber_service.this,plumber.class));
                Toast.makeText(plumber_service.this, "Helloo", Toast.LENGTH_SHORT).show();
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String phnoTXT=phno.getText().toString();
                String ratingTXT=rating.getText().toString();
                String amountTXT=amount.getText().toString();
                Boolean checkinsertdata =DB.insertuserdata2(nameTXT,phnoTXT,ratingTXT,amountTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(plumber_service.this, "NEW ENTRY Inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(plumber_service.this, "Not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
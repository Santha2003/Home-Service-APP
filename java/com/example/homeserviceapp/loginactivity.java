package com.example.homeserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {
      EditText username,password;
      Button btnlogin;
      DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        username=(EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        btnlogin=(Button) findViewById(R.id.btnsignin1);
       DB=new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                      String user=username.getText().toString();
                      String pass=password.getText().toString();

                      if(user.equals("")||pass.equals(""))
                          Toast.makeText(loginactivity.this, "Please enter all fileds", Toast.LENGTH_SHORT).show();
                      else {
                          Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                          if(checkuserpass==true)
                          {
                              Toast.makeText(loginactivity.this, "sign in successfully", Toast.LENGTH_SHORT).show();
                              Intent intent=new Intent(getApplicationContext(),homescreen.class);
                              intent.putExtra("name",user);
                              startActivity(intent);
                          }
                          else {
                              Toast.makeText(loginactivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                          }
                      }
            }
        });
    }
}
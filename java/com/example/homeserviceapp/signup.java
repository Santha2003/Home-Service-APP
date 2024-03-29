package com.example.homeserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
 EditText username,password,repassword;
 Button signup,signin;
 DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        repassword=(EditText) findViewById(R.id.repassword);
        signup=(Button) findViewById(R.id.btnsignup);
        signin=(Button) findViewById(R.id.btnsignin);
        DB =new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                      String user=username.getText().toString();
                      String pass=password.getText().toString();
                      String repass=repassword.getText().toString();

                      if(user.equals("")|| pass.equals("")|| repass.equals(""))
                      {
                          Toast.makeText(signup.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                      }
                      else {
                          if(pass.equals(repass))
                          {

                              Boolean checkuser=DB.checkusername(user);
                              if(checkuser==false){
                                  Boolean insert=DB.userdata(user,pass);
                                  if (insert==true){
                                      Toast.makeText(signup.this, "Sign up Successfully", Toast.LENGTH_SHORT).show();
                                      Intent intent=new Intent(getApplicationContext(),homescreen.class);
                                      startActivity(intent);
                                  }
                                  else {
                                      Toast.makeText(signup.this, "Registeration Failed", Toast.LENGTH_SHORT).show();
                                  }
                              }
                              else {
                                  Toast.makeText(signup.this, "user already exixts", Toast.LENGTH_SHORT).show();
                              }
                          }else {
                              Toast.makeText(signup.this, "password Not Matching", Toast.LENGTH_SHORT).show();
                          }
                      }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),loginactivity.class);
                startActivity(intent);
            }
        });
    }
}
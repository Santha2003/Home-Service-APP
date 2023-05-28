package com.example.homeserviceapp;

import static com.example.homeserviceapp.R.id.logout;
import static com.example.homeserviceapp.R.id.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class homescreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    String name,pass;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        CardView cleaning=findViewById(R.id.cleaning);
        name=getIntent().getStringExtra("name");
        cleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.equals("santha")) {
                    startActivity(new Intent(homescreen.this, cleaning_service.class));
                }
                else{
                    startActivity(new Intent(homescreen.this,cleaning.class));
                }
            }
        });
       CardView plumber=findViewById(R.id.plumber);
       plumber.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(name.equals("santha")) {
                   startActivity(new Intent(homescreen.this,plumber_service.class));               }
               else{
                   startActivity(new Intent(homescreen.this,plumber.class));
               }

           }
       });
       CardView painting=findViewById(R.id.painting);
       painting.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(name.equals("santha")) {
                   startActivity(new Intent(homescreen.this,painting_service.class));
               }
               else{
                   startActivity(new Intent(homescreen.this,painting.class));
               }


           }
       });
        CardView mechanic=findViewById(R.id.mechanic);
        mechanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.equals("santha")) {
                    startActivity(new Intent(homescreen.this,mechanic_service.class));
                }
                else{
                    startActivity(new Intent(homescreen.this,mechanic.class));
                }

            }
        });
        CardView electrician=findViewById(R.id.electrician);
        electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.equals("santha")) {
                    startActivity(new Intent(homescreen.this,electrician_service.class));
                }
                else{
                    startActivity(new Intent(homescreen.this,electrician.class));
                }

            }
        });
        CardView maid=findViewById(R.id.maid);
        maid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.equals("santha")) {
                    startActivity(new Intent(homescreen.this,maid_service.class));

                }
                else{
                    startActivity(new Intent(homescreen.this,maid.class));
                }
            }
        });



        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch(item.getItemId()){
            case R.id.home:
                Toast.makeText(homescreen.this, "Home", Toast.LENGTH_LONG).show();


                break;
            case R.id.setting:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                finish();

            break;
        }
        return false;

    }
}
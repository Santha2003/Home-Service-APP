package com.example.homeserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class cleaning_Booking extends AppCompatActivity {
    TextView name;
    TextView phno;
    TextView rating,dateText,amount,service,address;
    Spinner time;
    Button Booking;
    String name1,phno1,rating1,amount1;
    DBHelper DB;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning_booking);
        name=findViewById(R.id.name);
        phno=findViewById(R.id.phno);
        rating=findViewById(R.id.rating);
        service=findViewById(R.id.service_types);
        amount=findViewById(R.id.amount);
        address=findViewById(R.id.addressedit);
        time=findViewById(R.id.spinner1);

        Booking=findViewById(R.id.booking);



        String name1=getIntent().getStringExtra("keyname");
        String phno1=getIntent().getStringExtra("keyphno");
        String rating1=getIntent().getStringExtra("keyrating");
        String amount1=getIntent().getStringExtra("kayamount");
        Toast.makeText(this, ""+amount1, Toast.LENGTH_SHORT).show();
        name.setText(name1);
        phno.setText(phno1);
        rating.setText(rating1);
        amount.setText(amount1);
        dateText = findViewById(R.id.date);
        DB=new DBHelper(this);

        Booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String serviceTXT=service.getText().toString();
               String dateTXT=dateText.getText().toString();
                String timeTXT = time.getSelectedItem().toString();

                String detailsTXT=address.getText().toString();

                Boolean checkinsertdata =DB.insertBookingdata(serviceTXT,name1,phno1,amount1,timeTXT,dateTXT,detailsTXT);
                Toast.makeText(cleaning_Booking.this, ""+checkinsertdata, Toast.LENGTH_SHORT).show();
                if(checkinsertdata==true)
                {
                    Toast.makeText(cleaning_Booking.this, "NEW ENTRY Inserted", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(cleaning_Booking.this,booking.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(cleaning_Booking.this, "Please choose another time", Toast.LENGTH_SHORT).show();
                }
            }
        });


                // Create a calendar instance to get the current date
        Calendar calendar = Calendar.getInstance();

        // Create a new date picker dialog and set its OnDateSetListener
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Update the date text box with the selected date
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        dateText.setText(selectedDate);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        // Set an OnClickListener to open the date picker dialog when the date text box is clicked
        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the date picker dialog
                datePickerDialog.show();
            }
        });


        Spinner dropdown = findViewById(R.id.spinner1);

        String[] items = new String[]{"10AM", "11AM", "12AM","1PM","2PM","3PM","4PM","5PM","6PM","7PM","8PM","9PM","10PM"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);

    }

}
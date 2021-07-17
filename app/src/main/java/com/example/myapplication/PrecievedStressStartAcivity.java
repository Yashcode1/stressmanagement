package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrecievedStressStartAcivity extends AppCompatActivity {

    Button startbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precieved_stress_start_acivity);

        startbtn = findViewById(R.id.startbutton);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent2 = new Intent(PrecievedStressStartAcivity.this,PreceivedStressNewAvtivity.class);
                startActivity(myintent2);
            }
        });
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class ChooseStressTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_stress_type);
        MaterialCardView card1 = findViewById(R.id.perceivedcard);
        MaterialCardView card2 = findViewById(R.id.presentcard);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent1 = new Intent(ChooseStressTypeActivity.this,PerceivedStressActivity.class);
                startActivity(myintent1);

            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent2 = new Intent(ChooseStressTypeActivity.this,PresentStressActivity.class);
                startActivity(myintent2);
            }
        });
    }
}
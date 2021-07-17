package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class QuestionnairResultActivity extends AppCompatActivity {

    TextView resulttxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnair_result);

        int value;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            value = bundle.getInt("stressresult");

            resulttxt = findViewById(R.id.restext);
            resulttxt.setText(String.valueOf(value));
        }


    }
}
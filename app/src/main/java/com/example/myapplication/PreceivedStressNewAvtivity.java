package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class PreceivedStressNewAvtivity extends AppCompatActivity {

    Button nextbtn, prevbtn;
    private int result = 0;
    private int qst = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preceived_stress_new_avtivity);

        //linking buttons from xml
        nextbtn = findViewById(R.id.nextbutton);
        prevbtn = findViewById(R.id.previousbutton);
        ViewFlipper vf = (ViewFlipper) findViewById(R.id.vf);
        TextView restxt = (TextView)findViewById(R.id.restext);

        //button functions
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unchecked();
                if(qst == 9){
                    Intent intent = new Intent(getApplicationContext(), QuestionnairResultActivity.class);
                    intent.putExtra("stressresult", result);
                    startActivity(intent);

                }else{
                    vf.showNext();
                    qst += 1;
                    Log.d("result", String.valueOf(result));
                    //restxt.setText(String.valueOf(qst));
                }

            }
        });
        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unchecked();
                vf.showNext();
                qst -= 1;
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        if (qst != 4 || qst != 5 || qst != 7 || qst != 8) {

            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch (view.getId()) {
                case R.id.radio1:
                    if (checked) {
                        result += 0;
                    }
                    break;
                case R.id.radio2:
                    if (checked) {
                        result += 1;
                    }
                    break;
                case R.id.radio3:
                    if (checked) {
                        result += 2;
                    }

                    break;
                case R.id.radio4:
                    if (checked) {
                        result += 3;
                    }

                    break;
                case R.id.radio5:
                    if (checked) {
                        result += 4;
                    }
            };
        }
        else{
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch (view.getId()) {
                case R.id.radio1:
                    if (checked) {
                        result += 4;
                    }
                    break;
                case R.id.radio2:
                    if (checked) {
                        result += 3;
                    }
                    break;
                case R.id.radio3:
                    if (checked) {
                        result += 2;
                    }

                    break;
                case R.id.radio4:
                    if (checked) {
                        result += 1;
                    }

                    break;
                case R.id.radio5:
                    if (checked) {
                        result += 0;
                    }

            }


        }
    }

    public void unchecked(){
        RadioGroup radioGroup=findViewById(R.id.radiogrp);
        radioGroup.clearCheck();
    }
}
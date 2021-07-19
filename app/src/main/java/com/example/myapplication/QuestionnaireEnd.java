package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class QuestionnaireEnd extends AppCompatActivity {

    private TextView txtProgress;
    private ProgressBar progressBar;
    private int pStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_end);

        int value;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            value = bundle.getInt("stressresult");

            //resulttxt = (TextView) findViewById(R.id.restxt);
            // resulttxt.setText(String.valueOf(value));


            TextView txtProgress = (TextView) findViewById(R.id.txtProgress);
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
            int percentage = (int)calc(value);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (pStatus >= percentage) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(pStatus);
                                txtProgress.setText(pStatus + " %");
                            }
                        });
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        pStatus++;
                    }
                }
            }).start();
        }
    }

    public double calc (int v){
        return v/40*100;

    }

    public String stresslevel (int v){
        if (v < 14) {
            return "Low stress Level";
        }
        else if (v < 27) {
            return "Medium Stress Level";
        }
        else {
            return "High Stress Level";
        }
    }

}
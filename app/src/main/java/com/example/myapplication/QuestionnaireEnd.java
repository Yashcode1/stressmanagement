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

            TextView resulttxt = (TextView) findViewById(R.id.stressleveltxt);

            TextView txtProgress = (TextView) findViewById(R.id.txtProgress);
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
            int x= (int)calc(value);
            resulttxt.setText(stresslevel(value));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (pStatus <= x) {
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
        double res = ((double)v/40.0)*100;

        if (res == 0){
            return 1;
        }else if(res >100){
            return 100;
        }else{
            return res;
        }

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
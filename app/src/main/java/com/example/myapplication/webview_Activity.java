package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class webview_Activity extends AppCompatActivity {

    WebView myWebView = (WebView) findViewById(R.id.webview);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        myWebView.loadUrl("http://www.example.com");

    }
}
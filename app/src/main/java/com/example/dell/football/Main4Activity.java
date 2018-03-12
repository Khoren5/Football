package com.example.dell.football;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main4Activity extends AppCompatActivity {
private WebView ligaweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ligaweb=findViewById(R.id.ligaweb);
        ligaweb.setWebViewClient(new WebViewClient());
        ligaweb.loadUrl("http://www.skysports.com/football/news");
    }
}

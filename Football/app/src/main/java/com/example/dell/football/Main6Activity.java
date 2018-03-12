package com.example.dell.football;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Main6Activity extends AppCompatActivity {
private WebView webView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
webView=findViewById(R.id.webView);
webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
       String a=getIntent().getStringExtra("kayq");
        webView.loadUrl(a);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}

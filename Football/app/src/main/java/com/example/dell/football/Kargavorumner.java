package com.example.dell.football;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Kargavorumner extends AppCompatActivity {
private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kargavorumner);
        list=findViewById(R.id.list);
    }
}

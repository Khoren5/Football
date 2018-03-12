package com.example.dell.football;

/**
 * Created by DELL on 07.02.2018.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by DELL on 07.02.2018.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
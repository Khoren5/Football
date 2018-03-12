package com.example.dell.football;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mtnell;
    private EditText anun;
private String a;
private Switch chak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtnell = findViewById(R.id.mtnell);
        chak=findViewById(R.id.chak);
anun=findViewById(R.id.anun);
final String t="a";
       chak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked==true){SharedPreferences sharedPreferences=getSharedPreferences("File",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString(t,"on");
            editor.apply();}else {SharedPreferences sharedPreferences=getSharedPreferences("File",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString(t,"off");
            editor.apply();
        }

    }
});SharedPreferences sharedPreferences=getSharedPreferences("File",Context.MODE_PRIVATE);
        a=sharedPreferences.getString(t,"off");
        if (a.equals("on")){
        chak.setChecked(true);
        Intent intent=new Intent(MainActivity.this,Main7Activity.class);
        startActivity(intent);
        }else chak.setChecked(false);
        mtnell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (anun.getText().length()>1){
                    chak.setChecked(true);
                Intent intent = new Intent(MainActivity.this, Main7Activity.class);
                startActivity(intent);
               }

            }
        });
    }

}



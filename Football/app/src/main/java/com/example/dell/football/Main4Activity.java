package com.example.dell.football;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
private Button ok,het;
private EditText parol,anun,parol1;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ok=findViewById(R.id.ok);
        parol=findViewById(R.id.parol);
        parol1=findViewById(R.id.parol1);
        anun=findViewById(R.id.anun);
        het=findViewById(R.id.het);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (anun.getText().length()>2&&parol.getText().length()>=4&&parol1.getText().toString().equals(parol.getText().toString())){
                    SharedPreferences sharedPreferences=getSharedPreferences("File",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString(anun.getText().toString(),parol.getText().toString());
                    editor.apply();
                    Intent intent=new Intent(Main4Activity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(Main4Activity.this,"Սխալ",Toast.LENGTH_SHORT).show();}

            }
        });
        het.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main4Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

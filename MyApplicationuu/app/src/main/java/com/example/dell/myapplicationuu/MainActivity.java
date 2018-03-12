package com.example.dell.myapplicationuu;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText login,password,ubdate1,idd;
private Button save,read,delete,update;
private TextView textView;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=findViewById(R.id.save);
        read=findViewById(R.id.read);
        idd=findViewById(R.id.idd);
        textView=findViewById(R.id.textView);
        delete=findViewById(R.id.delete);
        update=findViewById(R.id.update);
        ubdate1=findViewById(R.id.upp);
        login=findViewById(R.id.login);
        password=findViewById(R.id.password);
final MyDBHelper myDBHelper=new MyDBHelper(this);

save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String loginn=login.getText().toString();
        String passwordd=password.getText().toString();
if (myDBHelper.myinsert(loginn,passwordd)){
    Toast.makeText(MainActivity.this,"save",Toast.LENGTH_SHORT).show();
}else {
    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
}
    }
});read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqLiteDatabase=myDBHelper.getWritableDatabase();
                Cursor cursor=sqLiteDatabase.rawQuery("Select  * from Football",null);
                StringBuilder builder=new StringBuilder();
                while (cursor.moveToNext()){
                    builder.append(cursor.getString(0)+"\n");
                    builder.append(cursor.getString(1)+"\n");
                    builder.append(cursor.getString(2)+"\n");
                }
                textView.setText(builder);
            }
        });
delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String id=idd.getText().toString();
        myDBHelper.mydelete(id);
    }
});
update.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String up=ubdate1.getText().toString();

        String id=idd.getText().toString();
        myDBHelper.update(up,id);

    }
});
    }
}

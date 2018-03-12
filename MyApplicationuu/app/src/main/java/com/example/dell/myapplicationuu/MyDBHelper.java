package com.example.dell.myapplicationuu;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper  extends SQLiteOpenHelper{
    private final static String DBname="Khorenyan";
    private String TBname="Football";
    private String idcol="id";
    private String logincol="login";
    private String passwordcol="password";
    public MyDBHelper(Context context) {
        super(context,DBname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table Football(id INTEGER PRIMARY KEY AUTOINCREMENT,login,password)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Football");
    }
    public boolean myinsert(String login1,String password1){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(logincol,login1);
        contentValues.put(passwordcol,password1);
        long t= sqLiteDatabase.insert(TBname,null,contentValues);
        sqLiteDatabase.close();
        if (t==-1){
            return false;}
            else {return true;
        }
    }
    public  void update(String passwordo,String id){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(passwordcol,passwordo);
        sqLiteDatabase.update(TBname,contentValues,"id=?",new String[]{id});
        sqLiteDatabase.close();
    }
    public void mydelete(String new_id){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete(TBname,"id=?",new String[]{new_id});
    }

}

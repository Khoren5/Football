package com.example.dell.football;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 01.02.2018.
 */

public class MyDBHolder extends SQLiteOpenHelper {
private final  static String DBname="Macht";
private String Tbname="Khagher";
private String idcol="id";
private String komand1col="komand1";
private String komand2col="komand2";
private String timecol="time";
private String calendarcol="calendar";
    public MyDBHolder(Context context) {
        super(context,DBname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table Khagher(id INTEGER PRIMARY KEY AUTOINCREMENT,komand1,time,komand2,calendar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("Drop table if exists Khagher");
    }
    public boolean myinsert(String komand11,String komand22,String timee,String calendar1){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(komand1col,komand11);
        contentValues.put(komand2col,komand22);
        contentValues.put(timecol,timee);
        contentValues.put(calendarcol,calendar1);
        long t=sqLiteDatabase.insert(Tbname,null,contentValues);
        if (t==-1){return false;}else {return true;}
    }
    public Cursor read(){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("Select * from Khagher",null);

    return  cursor;}
}

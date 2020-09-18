package com.example.loginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Student.db";
    public static final String TABLE_NAME="Login";
    public Database(@Nullable Context context) {
        super(context ,DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(USER_NAME text,PASSWORD text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public void insertValues(String a,String b){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("USER_NAME",a);
        values.put("PASSWORD",b);
        db.insert("Login",null,values);
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return res;
    }
    public Cursor CheckAllData(String user_name){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE USER_NAME =? ", new String[]{user_name});
        return res;
    }
}

package com.example.abdulahad.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abdul Ahad on 3/15/2018.
 */

public class DbHelper extends SQLiteOpenHelper{

    public static final String DB_Name = "Students.db";
    public static final String Table_Name = "Student";


    //creates the database
    public DbHelper(Context context) {
        super(context, DB_Name, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();         //gets writing methods of the database
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, CNIC INTEGER, EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }
    public boolean insertData(String name,int cnic, String email) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("CNIC", cnic);
        contentValues.put("EMAIL", email);
        long SaveResult =database.insert(Table_Name,null,contentValues);
        if(SaveResult>0)
            return true;
        else
            return false;
    }
    public Cursor GetInformation(String CNIC) {
        SQLiteDatabase database = this.getReadableDatabase();
        String query = " SELECT * FROM " + Table_Name + " WHERE CNIC = '" + CNIC +"'";
        Cursor cursor = database.rawQuery(query, null);
        return cursor;
    }
}
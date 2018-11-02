package com.example.ketri.korektawadpostawy.Exercises;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jjoe64.graphview.series.DataPoint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ketri on 27.09.2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "user_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DATE";
    public static final String COL_3 = "POINTS";
    public static final String COL_4 = "MOOD";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, DATE DATETIME DEFAULT CURRENT_DATE, POINTS INTEGER , MOOD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData( int points, String mood) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3,points);
        contentValues.put(COL_4,mood);

        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public int getSUM() {
    String countQuery = "SELECT SUM("+COL_3+") as Total FROM " + TABLE_NAME ;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    cursor.moveToFirst();
    int sum =cursor.getInt(cursor.getColumnIndex("Total"));
    cursor.close();
    return sum;

    }
    public DataPoint[] getData(){

        String countQuery = "SELECT "+COL_3+" as Points, "+COL_1+" as Date FROM " + TABLE_NAME ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        DataPoint[] dp=new DataPoint[cursor.getCount()];
        for(int i =0 ;i<cursor.getCount();i++){

                cursor.moveToNext();
                dp[i] = new DataPoint(cursor.getColumnIndex("Points"),i);

        }
        cursor.close();
        return dp;
    }

}

package com.example.ketri.korektawadpostawy.Exercises;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public int sumPoints(){
        int sumPoints = 0;
        String sql ="SELECT COUNT(*) FROM "+TABLE_NAME;
       Cursor cursor= getWritableDatabase().rawQuery(sql,null);
      if( cursor.moveToFirst()){
     do{    cursor.getColumnIndex(COL_3);}
     while (cursor.moveToNext());


     }
       cursor.close();

                return sumPoints;
    }

//    public Cursor getSUM() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cur = db.rawQuery("SELECT SUM(" + COL_3 + ") as Total FROM " + TABLE_NAME, null);
//        if (cur.moveToFirst()) {
//
//            int total = cur.getInt(cur.getColumnIndex("Total"));}
//        return cur;
//    }
public int getSUM() {

    String countQuery = "SELECT SUM("+COL_3+") as Total FROM " + TABLE_NAME ;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    cursor.moveToFirst();
    int sum =cursor.getInt(cursor.getColumnIndex("Total"));
    cursor.close();
    return sum;
}
}

package com.example.ketri.korektawadpostawy.Exercises;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ketri.korektawadpostawy.Exercises.model.Defect;
import com.jjoe64.graphview.series.DataPoint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    public static final String COL_5 = "DEFECT";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, DATE DATETIME DEFAULT CURRENT_DATE, POINTS INTEGER , MOOD TEXT, DEFECT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(int points, String mood, String defects) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3, points);
        contentValues.put(COL_4, mood);
        contentValues.put(COL_5, defects);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public int getSUM() {
        String countQuery = "SELECT SUM(" + COL_3 + ") as Total FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.moveToFirst();
        int sum = cursor.getInt(cursor.getColumnIndex("Total"));
        cursor.close();
        return sum;
    }
    public List<Defect> getDefect() {
        List<Defect> defectList = new ArrayList<Defect>();
        String countQuery = "SELECT " + COL_5 + " as defect FROM " + TABLE_NAME+ " WHERE " + COL_5 + " IS NOT NULL";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        try {
            while (cursor.moveToNext()) {
                Defect defects = new Defect();
                //String defects = cursor.getString(cursor.getColumnIndex("defect"));
                defects.setName(cursor.getString(cursor.getColumnIndex("defect")));
                defectList.add(defects);
            }
        } finally {
            cursor.close();
        }


        //String defect = cursor.getString(cursor.getColumnIndex("defect"));

        return defectList;
    }
//    public String getDefect() {
//        String countQuery = "SELECT " + COL_5 + " as defect FROM " + TABLE_NAME + " WHERE " + COL_5 + " LIKE 'Skolioza'";
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.moveToFirst();
//        String defect = cursor.getString(cursor.getColumnIndex("defect"));
//        cursor.close();
//        return defect;
//    }
//    public String getDefectKif() {
//        String countQuery = "SELECT " + COL_5 + " as defect FROM " + TABLE_NAME + " WHERE " + COL_5 + " LIKE 'Kifoza'";
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.moveToFirst();
//        String defect = cursor.getString(cursor.getColumnIndex("defect"));
//        cursor.close();
//        return defect;
//    }

    public DataPoint[] getPointsDateTab() throws ParseException {

        String countQuery = "SELECT " + COL_3 + " as Points, " + COL_2 + " as Date FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            String temp = cursor.getString(cursor.getColumnIndex("Date"));
            SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd",Locale.GERMAN);
            SimpleDateFormat sdfOut = new SimpleDateFormat("dd.MM",Locale.GERMAN);
            Date date = sdfIn.parse(temp);
            dp[i] = new DataPoint(Double.parseDouble(sdfOut.format(date)), cursor.getDouble(cursor.getColumnIndex("Points")));
        }
        cursor.close();
        return dp;
    }

}

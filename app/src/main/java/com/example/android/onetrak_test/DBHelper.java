package com.example.android.onetrak_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static int targetBase = 4000;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "onetrak";

    public static final String TABLE_DATA = "data";

    public static final String KEY_ID = "_id";
    public static final String KEY_DATE = "date";
    public static final String KEY_AEROBIC = "aerobic";
    public static final String KEY_RUN = "run";
    public static final String KEY_WALK = "walk";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_DATA + "(" + KEY_ID + " String primary key," + KEY_DATE + " text," +
                KEY_AEROBIC + " text," + KEY_RUN + " text," + KEY_WALK + " text" + ")" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists " + TABLE_DATA);

        onCreate(db);

    }


}


package com.mirea.kt.android2023;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyAppSQLiteHelper extends SQLiteOpenHelper {
    public MyAppSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
    super(context, name, factory, version);
}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + "TABLE_MUSEUMS" + " (" +
                "_id integer primary key autoincrement," +
                "address text," +
                "telephone integer," +
                "website text" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

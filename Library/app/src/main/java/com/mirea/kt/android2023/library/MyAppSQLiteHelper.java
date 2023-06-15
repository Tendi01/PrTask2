package com.mirea.kt.android2023.library;

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
        db.execSQL("create table " + "TABLE_BOOKS" + " (" +
                "_id integer primary key autoincrement," +
                "title text," +
                "author text," +
                "rack_number integer," +
                "shelf_number integer," +
                "vendor_code integer" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

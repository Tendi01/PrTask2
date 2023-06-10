package com.mirea.kt.datastorageapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyAppSQLiteHelper extends SQLiteOpenHelper {
    //класс расширяет стандартный абстрактный класс SQLiteOpenHelper

    public MyAppSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //вызывается при первом создании базы данных
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + "TABLE_DOCTORS" + " (" + "_id integer primary key autoincrement," + "name text,"
                + "specialty text," + "certificationFlag integer" + ");");
    }


    //вызывается при модификации базы данных
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //если версия изменилась, то вносим нужные нам изменения
    }
}


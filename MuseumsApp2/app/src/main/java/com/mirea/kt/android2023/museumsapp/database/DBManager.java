package com.mirea.kt.android2023.museumsapp.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mirea.kt.android2023.museumsapp.model.Museum;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private SQLiteOpenHelper sqLiteOpenHelper;

    public DBManager(SQLiteOpenHelper sqLiteOpenHelper) {
        this.sqLiteOpenHelper = sqLiteOpenHelper;
    }

    public boolean save(Museum museum) {
        SQLiteDatabase database = sqLiteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", museum.getName());
        contentValues.put("description", museum.getDescription());
        contentValues.put("phoneNumber", museum.getPhoneNumber());
        contentValues.put("url", museum.getUrl());
        contentValues.put("address", museum.getAddress());
        contentValues.put("imagePath", museum.getImagePath());

        long rowId = database.insert("museums", null, contentValues);
        contentValues.clear();
        database.close();

        return rowId != -1;
    }

    public List<Museum> getAllMuseums() {
        List<Museum> museums = new ArrayList<>();
        SQLiteDatabase database = sqLiteOpenHelper.getWritableDatabase();
        Cursor cursor = database.query("museums",
                null, null, null,
                null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                String phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow("phoneNumber"));
                String url = cursor.getString(cursor.getColumnIndexOrThrow("url"));
                String address = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                int imagePath = cursor.getInt(cursor.getColumnIndexOrThrow("imagePath"));

                museums.add(new Museum(id, name, description, phoneNumber, url, address, imagePath));
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();

        return museums;
    }

    public Museum getMuseumById(int id) {
        SQLiteDatabase database = sqLiteOpenHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM museums WHERE _id = ?", new String[]{String.valueOf(id)});

        if (cursor.moveToFirst()) {

            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
            String phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow("phoneNumber"));
            String url = cursor.getString(cursor.getColumnIndexOrThrow("url"));
            String address = cursor.getString(cursor.getColumnIndexOrThrow("address"));
            int imagePath = cursor.getInt(cursor.getColumnIndexOrThrow("imagePath"));

            return new Museum(id, name, description, phoneNumber, url, address, imagePath);
        }

        cursor.close();
        database.close();

        return null;
    }
}

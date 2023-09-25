package com.mirea.kt.android2023;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private SQLiteOpenHelper sqLiteHelper;
    public DBManager(SQLiteOpenHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }

    public List<Museums> getAllMuseums() {
        List<Museums> museums = new ArrayList<>();

        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_MUSEUMS",
                null, null, null,
                null, null, null);

        if (dbCursor.moveToFirst()) {
            do {
                int id = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("_id"));
                String address = dbCursor.getString(dbCursor.getColumnIndexOrThrow("address"));
                int telephone = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("telephone"));
                String website = dbCursor.getString(dbCursor.getColumnIndexOrThrow("website"));


                museums.add(new Museums(id, address, telephone, website));
            } while (dbCursor.moveToNext());
        }

        dbCursor.close();
        db.close();

        return museums;
    }

}

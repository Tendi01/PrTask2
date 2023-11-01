package com.mirea.kt.android2023;

import android.content.ContentValues;
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

    public boolean saveMuseum(Museums museums) {
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
       cv.put("id", museums.getId());
        cv.put("name", museums.getName());
        cv.put("address", museums.getAddress());
        cv.put("telephone", museums.getTelephone());
      cv.put("website", museums.getTelephone());

        long rowId = db.insert("TABLE_MUSEUMS", null, cv);
        cv.clear();
        db.close();
        return rowId != -1;
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
                String name = dbCursor.getString(dbCursor.getColumnIndexOrThrow("_name"));
               /* String address = dbCursor.getString(dbCursor.getColumnIndexOrThrow("address"));
                String telephone = dbCursor.getString(dbCursor.getColumnIndexOrThrow("telephone"));
                String website = dbCursor.getString(dbCursor.getColumnIndexOrThrow("website"));*/
                String picture =dbCursor.getString(dbCursor.getColumnIndexOrThrow("picture"));


                museums.add(new Museums(id, name,picture));
            } while (dbCursor.moveToNext());
        }

        dbCursor.close();
        db.close();

        return museums;
    }

    public Museums getMuseums(int id) {
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
//всё из этой таблицы
        Cursor dbCursor = db.rawQuery("SELECT * FROM TABLE_MUSEUMS WHERE _id = ?", new String[] {String.valueOf(id)});

        Museums museums = null;
        if (dbCursor.moveToFirst()) {
            do {
                String name = dbCursor.getString(dbCursor.getColumnIndexOrThrow("name"));
                String address = dbCursor.getString(dbCursor.getColumnIndexOrThrow("address"));
                String telephone = dbCursor.getString(dbCursor.getColumnIndexOrThrow("telephone"));
                String website = dbCursor.getString(dbCursor.getColumnIndexOrThrow("website"));
                museums = new Museums(name, address, telephone, website);
            } while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();

        return museums;
    }
    public boolean checkId(int id) {
        List<Museums> museums = getAllMuseums();

        for (Museums museum: museums) {
            if (museum.getId() == id) {
                return true;
            }
        }
        return false;
    }

}

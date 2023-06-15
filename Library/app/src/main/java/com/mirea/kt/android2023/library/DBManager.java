package com.mirea.kt.android2023.library;

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

    public boolean saveBook(Book book) {
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("title", book.getTitle());
        cv.put("author", book.getAuthor());
        cv.put("rack_number", book.getRackNumber());
        cv.put("shelf_number", book.getShelfNumber());
        cv.put("vendor_code", book.getVendorCode());

        long rowId = db.insert("TABLE_BOOKS", null, cv);
        cv.clear();
        db.close();

        return rowId != -1;
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_BOOKS",
                null, null, null,
                null, null, null);

        if (dbCursor.moveToFirst()) {
            do {
                int id = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("_id"));
                String title = dbCursor.getString(dbCursor.getColumnIndexOrThrow("title"));
                String author = dbCursor.getString(dbCursor.getColumnIndexOrThrow("author"));
                int rackNumber = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("rack_number"));
                int shelfNumber = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("shelf_number"));
                int vendorCode = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("vendor_code"));

                books.add(new Book(id, shelfNumber, vendorCode, author, rackNumber, title));
            } while (dbCursor.moveToNext());
        }

        dbCursor.close();
        db.close();

        return books;
    }

    public void deleteBook(int id) {
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();

        db.delete("TABLE_BOOKS", "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public Book getBook(int id) {
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();

        Cursor dbCursor = db.rawQuery("SELECT * FROM TABLE_BOOKS WHERE _id = ?", new String[] {String.valueOf(id)});

        Book book = null;
        if (dbCursor.moveToFirst()) {
            do {
                String title = dbCursor.getString(dbCursor.getColumnIndexOrThrow("title"));
                String author = dbCursor.getString(dbCursor.getColumnIndexOrThrow("author"));
                int rackNumber = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("rack_number"));
                int shelfNumber = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("shelf_number"));
                int vendorCode = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("vendor_code"));
                book = new Book(id, shelfNumber, vendorCode, author, rackNumber, title);
            } while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();

        return book;
    }

    public boolean checkVendorCode(int vendorCode) {
        List<Book> books = getAllBooks();

        for (Book book : books) {
            if (book.getVendorCode() == vendorCode) {
                return true;
            }
        }
        return false;
    }
}

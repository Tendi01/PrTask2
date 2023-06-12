package com.mirea.kt.android2023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BooksDatabase extends SQLiteOpenHelper {

//конструктор
    public BooksDatabase(@Nullable Context context) {
        super(context , "Book.db" , null , 1 );
    }

//Переопределенный метод onCreate создает таблицу File в базе данных SQLite,
// содержащую два столбца: Name и Position. Name указывает имя файла,
// а Position является целочисленным значением, которое задает позицию файла в списке.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table File(Name TEXT primary key , Position INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//Метод Insert добавляет новую запись в таблицу File,
// используя переданные значения name и position в соответствующие столбцы в базе данных.
    public void Insert(String name , int postition){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name" ,name) ;
        contentValues.put("Position",postition);

        db.insert("File" , null , contentValues);
        db.close();
    }

//Метод getData получает все записи из таблицы File и возвращает курсор,
// чтобы можно было считывать значения из каждой строки и использовать их в приложении.
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from File" ,null);
        return cursor ;
    }

//Метод Delete удаляет запись из таблицы File,
// где значение в столбце Name соответствует переданному имени файла.
    public void Delete(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("File", "Name=?" , new String[]{name});
        db.close();
    }

}

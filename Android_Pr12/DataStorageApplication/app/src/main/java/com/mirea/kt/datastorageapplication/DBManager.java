package com.mirea.kt.datastorageapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager {
    //Данный класс содержит методы манипуляции данными (добавление, удаление, выборка)
    private SQLiteOpenHelper sqLiteOpenHelper; //переменная - ссылка на SQLiteOpenHelper

    public DBManager(SQLiteOpenHelper sqLiteOpenHelper) {
        this.sqLiteOpenHelper = sqLiteOpenHelper;  //конструктор для инициализации переменной SQLiteOpenHelper
    }


    //метод добавления данных объекта Doctor в таблицу базы данных
    public boolean savePersonToDatabase(Doctor doctor) {
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        //получили ссылку на базу данных

        //создание переменной для хранения данных в формате "ключ-значение"
        //по сути формируем запись для вставки в БД
        ContentValues cv = new ContentValues();
        cv.put("name", doctor.getName());
        cv.put("specialty", doctor.getSpecialty());
        cv.put("certificationFlag", doctor.getCertificationFlag());

        //втавка записи в БД
        //метод возвращает номер строки в случае успешной вставки или -1, если произошла ошибка
        long rowId = db.insert("TABLE_DOCTORS", null, cv);
        cv.clear(); //очистка
        db.close(); //закрытие базы данных
        return rowId != -1; //возвращаем результат вставки
    }


    //выборка из таблицы TABLE_DOCTORS всех записей
    public ArrayList<Doctor> loadAllPersonsFromDatabase() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_DOCTORS", null, null, null, null, null, null);
        if (dbCursor.moveToFirst()) {
            do {
                String flName = dbCursor.getString(dbCursor.getColumnIndexOrThrow("name"));
                String specialty = dbCursor.getString(dbCursor.getColumnIndexOrThrow("specialty"));
                int certificationFlag = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("certificationFlag"));
                doctors.add(new Doctor(flName, specialty, certificationFlag));
            } while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        return doctors;
    }
}
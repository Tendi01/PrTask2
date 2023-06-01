package com.mirea.kt.datastorageapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorActivity extends AppCompatActivity {
    //создание экземпляра класса DBManeger

    private SQLiteOpenHelper sqLiteOpenHelper; //переменная - ссылка на SQLiteOpenHelper

    public DoctorActivity(SQLiteOpenHelper sqLiteOpenHelper) {
        this.sqLiteOpenHelper = sqLiteOpenHelper;  //конструктор для инициализации переменной SQLiteOpenHelper
    }

    private void setSupportActionBar(Toolbar tb) {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Second");
            ab.setHomeButtonEnabled(true); //включение поддержки кнопки назад в ActionBar
            ab.setDisplayHomeAsUpEnabled(true); //отображение кнопки назад
        }

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
            RecyclerView rcView = findViewById(R.id.recyclerView);
            DoctorAdapter adapter = new DoctorAdapter(doctor);
            rcView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rcView.setAdapter(adapter);
        }

        }


}
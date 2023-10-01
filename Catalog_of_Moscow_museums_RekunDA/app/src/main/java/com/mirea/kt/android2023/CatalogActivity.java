package com.mirea.kt.android2023;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class CatalogActivity extends AppCompatActivity //implements MuseumsAdapter.OnMuseumsClickListener
{

    private RecyclerView recyclerView;
    private DBManager dbManager;
    private static final String TAG = "MuseumsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        Log.d(TAG, "onCreate: Activity started");

        //recyclerView = findViewById(R.id.recyclerView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("МУЗЕИ МОСКВЫ");
            actionBar.setHomeButtonEnabled(true);// включение поддержки кнопки назад в AcrionBar
            actionBar.setDisplayHomeAsUpEnabled(true); //отображение кнопки назад
        }
        //получение списка из бд
        dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //MuseumsAdapter museumsAdapter = new MuseumsAdapter(dbManager.getAllMuseums(), this);
        //recyclerView.setAdapter(museumsAdapter);
    }
/*
    @Override
    public void onMuseumsClick(Museums book, int position) {
        Log.d(TAG, "onMuseumsClick: Museum Pressed");

        Intent intent = new Intent(this, MuseumsActivity.class);
        intent.putExtra("id", book.getId());
        startActivity(intent);
    }
*/
}
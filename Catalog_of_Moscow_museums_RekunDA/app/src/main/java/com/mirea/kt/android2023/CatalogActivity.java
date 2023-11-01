package com.mirea.kt.android2023;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;


import java.util.ArrayList;

public class CatalogActivity extends AppCompatActivity implements MuseumsAdapter.OnMuseumsClickListener {

    private RecyclerView recyclerView;
    private DBManager dbManager;
    private static final String TAG = "Catalog Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        Log.d(TAG, "onCreate: Activity started");

        recyclerView = findViewById(R.id.recyclerView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("МУЗЕИ МОСКВЫ");
        }

        //получение списка из бд

        if (dbManager!=null){
        Museums museums = new Museums();
        museums.setId(1);
        museums.setName("Государственный исторический музей");
        museums.setAddress("geo:55.75526152391502, 37.61766500806037");
        museums.setTelephone("84956924019");
        museums.setWebsite("https://shm.ru/");
        if (!dbManager.checkId(museums.getId())) {
            dbManager.saveMuseum(museums);
        }
        museums.setId(2);
        museums.setName("Государственная третьяковская галерея");
        museums.setAddress("geo:55.74181726470635, 37.62103359048664");
        museums.setTelephone("84959570727");
        museums.setWebsite("https://www.tretyakovgallery.ru/");
        if (!dbManager.checkId(museums.getId())) {
            dbManager.saveMuseum(museums);
        }
        museums.setId(3);
        museums.setName("Музей-заповедник Царицыно");
        museums.setAddress("geo:55.61180856549206, 37.68618078486653");
        museums.setTelephone("84953224433");
        museums.setWebsite("http://www.tsaritsyno-museum.ru/");
        if (!dbManager.checkId(museums.getId())) {
            dbManager.saveMuseum(museums);
        }
    }
        dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        MuseumsAdapter museumsAdapter = new MuseumsAdapter(dbManager.getAllMuseums(), this);
        recyclerView.setAdapter(museumsAdapter);



    }
    @Override
    public void onMuseumsClick(Museums museums, int position) {
        Log.d(TAG, "onMuseumsClick: Museum Pressed");

        Intent intent = new Intent(this, MuseumsActivity.class);
        intent.putExtra("id", museums.getId());
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();

        recyclerView.setAdapter(new MuseumsAdapter(dbManager.getAllMuseums(), this));
    }
}
package com.mirea.kt.android2023;


import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MuseumsActivity extends AppCompatActivity {
    private TextView textViewName, textViewAddress, textViewTelephone, textViewWebsite;
    private DBManager dbManager;
    private static final String TAG = "MuseumsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museums);
        Log.d(TAG, "onCreate: Activity started");

        textViewName= findViewById(R.id.textViewMuseumsName);
        textViewAddress = findViewById(R.id.textViewMuseumsAddress);
        textViewTelephone = findViewById(R.id.textViewMuseumsTelephone);
        textViewWebsite = findViewById(R.id.textViewMuseumsWedsite);

       dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));

       int id = getIntent().getIntExtra("id", -1);
       Museums museum = dbManager.getMuseums(id);

       Toolbar toolbar = findViewById(R.id.toolbarMuseums);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(museum.getName());
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        textViewName.setText(museum.getName());
        textViewAddress.setText("Адрес: " + museum.getAddress());
        textViewTelephone.setText("Номер телефона: " + museum.getTelephone());
        textViewWebsite.setText("Сайт: " + museum.getWebsite());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Log.d(TAG, "onOptionsItemSelected: Back Button Pressed");

            onBackPressed();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

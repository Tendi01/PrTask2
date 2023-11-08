package com.mirea.kt.android2023.museumsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.mirea.kt.android2023.museumsapp.database.DBManager;
import com.mirea.kt.android2023.museumsapp.database.MyAppSQLiteHelper;
import com.mirea.kt.android2023.museumsapp.model.Museum;

import java.net.URLEncoder;

public class MuseumActivity extends AppCompatActivity {

    private TextView textViewName, textViewDescription, textViewPhoneNumber, textViewAddress, textViewUrl;
    private ImageView  imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);

        textViewName = findViewById(R.id.textViewMuseumName);
        textViewDescription = findViewById(R.id.textViewMuseumDescription);
        textViewPhoneNumber = findViewById(R.id.textViewMuseumPhoneNumber);
        textViewAddress = findViewById(R.id.textViewMuseumAddress);
        textViewUrl = findViewById(R.id.textViewMuseumURL);
        imageView = findViewById(R.id.imageViewMuseum);

        DBManager dbManager = new DBManager(new MyAppSQLiteHelper(this, "museums.db", null, 1));

        int museumId = getIntent().getIntExtra("museumId", -1);
        Museum museum = dbManager.getMuseumById(museumId);

        Toolbar toolbar = findViewById(R.id.toolbarMuseum);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Музей");
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        textViewName.setText(museum.getName());
        textViewDescription.setText(museum.getDescription());
        textViewPhoneNumber.setText(museum.getPhoneNumber());
        textViewAddress.setText(museum.getAddress());
        textViewUrl.setText(museum.getUrl());
        imageView.setImageResource(museum.getImagePath());

        textViewPhoneNumber.setOnClickListener(x -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + museum.getPhoneNumber()));
            startActivity(intent);
        });

        textViewAddress.setOnClickListener(x -> {
            Intent  intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(String.format("geo:0,0?q=%s",
                            URLEncoder.encode(museum.getAddress()))));
            startActivity(intent);
        });

        textViewUrl.setOnClickListener(x -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(museum.getUrl()));
            startActivity(browserIntent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
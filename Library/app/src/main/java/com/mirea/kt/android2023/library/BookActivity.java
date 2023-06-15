package com.mirea.kt.android2023.library;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {

    private TextView textViewTitle, textViewAuthor, textViewRackNumber, textViewShelfNumber, textViewVendorCode;
    private DBManager dbManager;
    private static final String TAG = "BookActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Log.d(TAG, "onCreate: Activity started");

        textViewTitle = findViewById(R.id.textViewBookTitle);
        textViewAuthor = findViewById(R.id.textViewBookAuthor);
        textViewRackNumber = findViewById(R.id.textViewBookRackNumber);
        textViewShelfNumber = findViewById(R.id.textViewBookShelfNumber);
        textViewVendorCode = findViewById(R.id.textViewBookVendorCode);

        dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));

        int id = getIntent().getIntExtra("id", -1);
        Book book = dbManager.getBook(id);

        Toolbar toolbar = findViewById(R.id.toolbarBook);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(book.getTitle());
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        textViewTitle.setText(book.getTitle());
        textViewAuthor.setText("Автор: " + book.getAuthor());
        textViewRackNumber.setText("Номер стеллажа: " + book.getRackNumber());
        textViewShelfNumber.setText("Номер полки: " + book.getShelfNumber());
        textViewVendorCode.setText("Артикул: " + book.getVendorCode());
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
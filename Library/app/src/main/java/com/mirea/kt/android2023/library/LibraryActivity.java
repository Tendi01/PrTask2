package com.mirea.kt.android2023.library;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class LibraryActivity extends AppCompatActivity implements BookAdapter.OnBookClickListener {

    private RecyclerView recyclerView;
    private DBManager dbManager;
    private static final String TAG = "LibraryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Log.d(TAG, "onCreate: Activity started");

        recyclerView = findViewById(R.id.recyclerView);
        Toolbar toolbar = findViewById(R.id.toolbarLibrary);
        dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Библиотека");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        BookAdapter bookAdapter = new BookAdapter(dbManager.getAllBooks(), this);
        recyclerView.setAdapter(bookAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_library, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add_book) {
            Log.d(TAG, "onOptionsItemSelected: Action Add Book Pressed");

            startActivity(new Intent(this, CreateBookActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBookClick(Book book, int position) {
        Log.d(TAG, "onBookClick: Book Pressed");

        Intent intent = new Intent(this, BookActivity.class);
        intent.putExtra("id", book.getId());
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(Book book, int position) {
        Log.d(TAG, "onDeleteClick: Delete Book Pressed");

        dbManager.deleteBook(book.getId());

        recyclerView.setAdapter(new BookAdapter(dbManager.getAllBooks(), this));
    }

    @Override
    protected void onResume() {
        super.onResume();

        recyclerView.setAdapter(new BookAdapter(dbManager.getAllBooks(), this));
    }
}
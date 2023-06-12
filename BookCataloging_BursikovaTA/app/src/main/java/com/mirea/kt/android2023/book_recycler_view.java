package com.mirea.kt.android2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONObject;

public class book_recycler_view extends AppCompatActivity {
    private HelperAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_recycler_view);
        BooksDatabase db = new BooksDatabase(getContext()) ;

        adapter = new HelperAdapter();

        RecyclerView rcView = findViewById(R.id.recyclerView); //связь списка
        rcView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //передаём управление
        rcView.setAdapter(adapter);
    }
}
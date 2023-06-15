package com.mirea.kt.android2023.library;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateBookActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextAuthor, editTextRackNumber, editTextShelfNumber, editTextVendorCode;
    private Button button;
    private DBManager dbManager;
    private static final String TAG = "CreateBookActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book);
        Log.d(TAG, "onCreate: Activity started");

        editTextTitle = findViewById(R.id.editTextCreateBookTitle);
        editTextAuthor = findViewById(R.id.editTextCreateBookAuthor);
        editTextRackNumber = findViewById(R.id.editTextCreateBookRackNumber);
        editTextShelfNumber = findViewById(R.id.editTextCreateBookShelfNumber);
        editTextVendorCode = findViewById(R.id.editTextCreateBookVendorCode);
        button = findViewById(R.id.buttonCreateBook);

        dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));

        Toolbar toolbar = findViewById(R.id.toolbarCreateBook);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Добавление новой книги");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        button.setOnClickListener(x -> {
            Log.d(TAG, "onCreate: Add Book Button Pressed");

            String title = editTextTitle.getText().toString();
            String author = editTextAuthor.getText().toString();
            String rackNumberString = editTextRackNumber.getText().toString();
            String shelfNumberString = editTextShelfNumber.getText().toString();
            String vendorCodeString = editTextVendorCode.getText().toString();

            if (title.isEmpty() || author.isEmpty() || rackNumberString.isEmpty() || shelfNumberString.isEmpty() || vendorCodeString.isEmpty()) {
                Toast.makeText(this, "Все поля должны быть заполнены!", Toast.LENGTH_LONG).show();
                return;
            }

            int rackNumber = Integer.parseInt(rackNumberString);
            int shelfNumber = Integer.parseInt(shelfNumberString);
            int vendorCode = Integer.parseInt(vendorCodeString);

            if (rackNumber < 1 || shelfNumber < 1 || vendorCode < 0) {
                Toast.makeText(this, "Неверный формат данных!", Toast.LENGTH_LONG).show();
                return;
            }

            Book book = new Book(shelfNumber, vendorCode, author, rackNumber, title);

            if (dbManager.checkVendorCode(book.getVendorCode())) {
                Toast.makeText(this, "Книга с таким артиклем уже существует!", Toast.LENGTH_LONG).show();
                return;
            }

            dbManager.saveBook(book);

            Toast.makeText(this, "Книга добавлена!", Toast.LENGTH_LONG).show();

        });
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
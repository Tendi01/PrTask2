package com.mirea.kt.android2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Activity started");

        Button btnEnter = findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(v -> {
            Log.d(TAG, "onCreate: Log In Button Pressed");

            EditText etLogin = findViewById(R.id.etLogin);
            EditText etPassword = findViewById(R.id.etPassword);
            TextView tvResult = findViewById(R.id.tvResult);

            DBManager dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));

            HashMap<String,String> map = new HashMap<>();
            map.put("lgn",etLogin.getText().toString());
            map.put("pwd",etPassword.getText().toString());
            map.put("g","RIBO-02-21");

            HTTPRunnable httpPOSTRunnable = new HTTPRunnable
                    ("POST", "https://android-for-students.ru/coursework/login.php", map);
            Thread th = new Thread(httpPOSTRunnable);
            th.start();
            try {
                th.join();
                Log.d(TAG, "onCreate: " + httpPOSTRunnable.getResponseBody());
            }catch (Exception e) {
                Log.d(TAG, "onCreate: " + e.getMessage());
                tvResult.setText("Ошибка подключения");
            }
            try {
                JSONObject jsonResponse = new JSONObject(httpPOSTRunnable.getResponseBody());
                int resultCode = jsonResponse.getInt("result_code");
                if(resultCode == 1) {
                    tvResult.setText("Успешный вход!");
                    Intent bookIntent = new Intent(this, CatalogActivity.class);
                    startActivity(bookIntent);
                }else{
                    tvResult.setText("Неверный логин или пароль!");
                }
            }catch (Exception e){
                tvResult.setText("Ошибка подключения!");
                Log.d(TAG, "onCreate: " + e.getMessage());
            }
        });
    }
}
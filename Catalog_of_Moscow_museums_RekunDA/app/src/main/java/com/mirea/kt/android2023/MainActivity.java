package com.mirea.kt.android2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Activity started");
        Button btnLogIn = findViewById(R.id.btnEnter);

        btnLogIn.setOnClickListener( v -> {
            Log.d(TAG, "onCreate: Log In Button Pressed");
            EditText etLogin = findViewById(R.id.etLogin);
            EditText etPassword = findViewById(R.id.etPassword);
            TextView tvResult = findViewById(R.id.tvResult);

            HashMap<String, String> requestBody = new HashMap<>();
            requestBody.put("lgn", etLogin.getText().toString());
            requestBody.put("pwd", etPassword.getText().toString());
            requestBody.put("g", "RIBO-02-21");


            HTTPRunnable httpRunnable = new HTTPRunnable
                    ("https://android-for-students.ru/coursework/login.php", requestBody);
            Thread th = new Thread(httpRunnable);
            th.start();
            try {
                th.join();
                Log.d(TAG, "onCreate: " + httpRunnable.getResponseBody());

            }catch (Exception ex) {
                Log.d(TAG, "onCreate: " + ex.getMessage());
                tvResult.setText("Ошибка подключения");
            }
            try {
                JSONObject jsonResponse = new JSONObject(httpRunnable.getResponseBody());
                int resultCode = jsonResponse.getInt("result_code");
                if(resultCode == 1) {
                    tvResult.setText("OK");
                    Intent MuseumsIntent = new Intent(this, CatalogActivity.class);
                    startActivity(MuseumsIntent);
                }else{
                    tvResult.setText("Неверный логин или пароль");
                }

            }catch (Exception ex){
                tvResult.setText("Ошибка подключения");
                Log.d(TAG, "onCreate: " + ex.getMessage());
            }

        });
    }
}
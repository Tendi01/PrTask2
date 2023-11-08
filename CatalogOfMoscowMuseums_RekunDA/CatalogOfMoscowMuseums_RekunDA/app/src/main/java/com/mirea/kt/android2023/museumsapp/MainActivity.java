package com.mirea.kt.android2023.museumsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mirea.kt.android2023.museumsapp.utils.HTTPRunnable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView textViewLoginInfo;
    private EditText editTextLogin;
    private EditText editTextPassword;
    private Button buttonLogin;
    private String login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLoginInfo = findViewById(R.id.textViewLoginInfo);
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(x -> {
            login = editTextLogin.getText().toString();
            password = editTextPassword.getText().toString();

            if (login.isEmpty() || password.isEmpty()) {
                textViewLoginInfo.setText("Поля не могут быть пустыми!");
                return;
            }

            String server = "https://android-for-students.ru";
            String serverPath = "/coursework/login.php";
            HashMap<String, String> map = new HashMap<>();
            map.put("lgn", login);
            map.put("pwd", password);
            map.put("g", "RIBO-02-21");
            HTTPRunnable httpRunnable = new HTTPRunnable(server + serverPath, map);
            Thread th = new Thread(httpRunnable);
            th.start();
            try {
                th.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    JSONObject jsonObject = new JSONObject(httpRunnable.getResponseBody());
                    int result = jsonObject.getInt("result_code");

                    if (result == 1) {
                        Toast.makeText(this, "Успешно!", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(MainActivity.this, MuseumsCatalogActivity.class);
                        startActivity(intent);
                    } else {
                        textViewLoginInfo.setText("Неверный логин или пароль!");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
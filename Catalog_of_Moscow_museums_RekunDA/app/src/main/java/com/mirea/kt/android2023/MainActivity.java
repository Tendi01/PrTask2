package com.mirea.kt.android2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //в методе onCreate устанавливается для представления содержимого макета с именем activity_main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Activity started"); //регистрирует отладочное сообщение

        //после нажатия на кнопку. Точка прослушивания кликов будет передана
        // на прослушиватель кликов
        Button btnEnter = findViewById(R.id.btnEnter); //находит кнопку с индентификатором btnEnter
//устанавливает слушатель кликов для кнопки btnLogIn. Вместо того, чтобы создавать анонимный объект OnClickListener,
// он использует лямбда-выражение для определения обработчика события onClick() кнопки. Лямбда-выражение позволяет определить
// анонимную функцию без необходимости создавать отдельный класс реализации OnClickListener.
// В итоге, при клике на кнопку btnEnter будет вызван метод, определенный в лямбда-выражении.
        btnEnter.setOnClickListener(v -> {
            Log.d(TAG, "onCreate: Log In Button Pressed");
            EditText etLogin = findViewById(R.id.etLogin);
            EditText etPassword = findViewById(R.id.etPassword);
            TextView tvResult = findViewById(R.id.tvResult);

            //Он создает HashMap с именем map и помещает в него несколько пар ключ-значение
            HashMap<String,String> map = new HashMap<>();
            map.put("lgn",etLogin.getText().toString());
            map.put("pwd",etPassword.getText().toString());
            map.put("g","RIBO-02-21");

            //Затем  создаем экземпляр пользовательского класса HTTPRunnable с некоторыми аргументами
            HTTPRunnable httpPOSTRunnable = new HTTPRunnable
                    ("POST", "https://android-for-students.ru/coursework/login.php", map);
            Thread th = new Thread(httpPOSTRunnable);
            th.start(); //запускает поток POST, стандарнтый поток ввода и ожидаем его завершения
            try {
                th.join(); //регистрирует ответ от сервера, если он успешен
                Log.d(TAG, "onCreate: " + httpPOSTRunnable.getResponseBody());

            }catch (Exception e) { //перехватывает любые исключения, возникающие на этом пути
                Log.d(TAG, "onCreate: " + e.getMessage());
                tvResult.setText("Ошибка подключения");
            }

//Затем он пытается проанализировать ответ как JSONObject и выполняет некоторую логику на основе значения result_code этого объекта.
            try {
                JSONObject jsonResponse = new JSONObject(httpPOSTRunnable.getResponseBody());
                int resultCode = jsonResponse.getInt("result_code");
                //Наконец, он обновляет текст tvResult TextView на основе результата этой логики.
                if(resultCode == 1) {
                    tvResult.setText("Успешный вход!");
                    //запуск активности, переход на новый экран в мобильном приложении
                   Intent museumsIntent = new Intent(getApplicationContext(), Museums.class);
                   startActivity(museumsIntent);
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
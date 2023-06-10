package com.mirea.kt.datastorageapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//слушателем является данная активити и класс MainActivity реализует интерфейс View.OnClickListener
    private EditText editTextName, editTextSpecialty, ediTextCertificationFlag;
    private DBManager dbManager;
    //переменная, через которую будет осуществляться доступ к базе данных и работа с данными

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //устанавливаем просмотр содержимого

        //инициализируем переменную dbManager в onCreate класса MainActivity,чтобы ссылка была сразу доступна при создании главной активити
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));

        //инициализируем ссылки виджетов EditText и Button. Обращаемся к их ID
        editTextName = findViewById(R.id.etName);
        editTextSpecialty = findViewById(R.id.etSpecialty);
        ediTextCertificationFlag = findViewById(R.id.etcertificationFlag);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnNext = findViewById(R.id.btNext);
        btnAdd.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    //сохранение значений из виджитов EditText в базу данных при нажатии на кнопку "Добавить"
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd) {
            if (this.dbManager != null) {
                String flName = editTextName.getText().toString();
                String specialty = editTextSpecialty.getText().toString();
                String certificationFlag = ediTextCertificationFlag.getText().toString();
                if (!flName.isEmpty() && !specialty.isEmpty() && !certificationFlag.isEmpty()) {
                    boolean result = dbManager.savePersonToDatabase(new Doctor(flName, specialty, Integer.parseInt(certificationFlag)));
                    if (result) {
                        Toast.makeText(this, R.string.insert_success, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, R.string.insert_error, Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                }
            }
            //реализация запуска второй активити по нажатию на кнопку продолжить
        }else if(v.getId() == R.id.btNext){
            startActivity(new Intent(this, DoctorActivity.class));
        }
    }
}
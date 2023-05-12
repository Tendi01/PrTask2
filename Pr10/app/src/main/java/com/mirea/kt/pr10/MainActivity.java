package com.mirea.kt.pr10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etRange1 = findViewById(R.id.etRange1);
        EditText etRange2 = findViewById(R.id.etRange2);
        EditText etDivider = findViewById(R.id.etDivider);
        TextView tvResult = findViewById(R.id.tvResult);
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(v -> {
            Log.i("Number_Div_tag", "Click_calc_button");
            String range1 = etRange1.getText().toString();
            String range2 = etRange2.getText().toString();
            String divider = etDivider.getText().toString();
            if (!range1.isEmpty() && !divider.isEmpty() && !range2.isEmpty() && Integer.parseInt(divider)>0 ) {
                String numbers="";

                for ( int i=Integer.parseInt(range1); i<=Integer.parseInt(range2); i++) {
                    if (i % Integer.parseInt(divider) == 0) {
                        numbers= numbers + String.valueOf(i) + " ";

                    }
                }
                Log.i("Number_Div_tag", "Result: " + numbers);
                tvResult.setText(numbers);
            }else{
                    Log.w("Number_Div_tag", "Empty term!");
                    Toast.makeText(getApplicationContext(), "Invalid terms!", Toast.LENGTH_LONG).show();
                }
        });
    }
}
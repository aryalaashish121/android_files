package com.example.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText salary;
    Button btn_calulate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salary = findViewById(R.id.salary_amount);
        btn_calulate = findViewById(R.id.calculate);

        btn_calulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float sal = Float.parseFloat(salary+"");
                Toast.makeText(MainActivity.this, "The value entred is "+sal, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

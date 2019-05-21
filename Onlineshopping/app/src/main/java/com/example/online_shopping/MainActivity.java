package com.example.online_shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button l_g;
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //ed = findViewById(R.id.edittext);
    l_g = findViewById(R.id.lg);
    
    l_g.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,LoginRegister.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Now please Register", Toast.LENGTH_SHORT).show();
        }
    });

    }
}
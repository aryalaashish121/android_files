package com.example.multiple_button_click_listner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1,b2,b3;
    String abc="Aashish";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.btn1);
        b1.setOnClickListener(this);
                
        b2=findViewById(R.id.btn2);
        b2.setOnClickListener(this);
        
        b3=findViewById(R.id.btn3);
        b3.setOnClickListener(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1onclick = new Intent(MainActivity.this, ButtonClickActivity.class);
                b1onclick.putExtra("NAME",abc);
                b1onclick.putExtra("USERNAME","ashish123");
                startActivity(b1onclick);
            }
        });
        
    }

    @Override
    public void onClick(View v) {
        
        switch (v.getId())
        { case R.id.btn1:
           Toast.makeText(this, "First button clicked",Toast.LENGTH_SHORT).show();
           break;
            case R.id.btn2:
                Toast.makeText(this, "Second button clicked", Toast.LENGTH_SHORT).show();
            break;
            case R.id.btn3:
                Toast.makeText(this, "Third button clicked", Toast.LENGTH_SHORT).show();
                break;

        }
    }


}

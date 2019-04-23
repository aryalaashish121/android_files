package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,bplus,bminus,buttonEqual;
    TextView number;
    float mValueOne, mValueTwo;
    boolean cal_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.one);
        b2=findViewById(R.id.two);
        b3=findViewById(R.id.three);
        b4=findViewById(R.id.four);
        b5=findViewById(R.id.five);
        b6=findViewById(R.id.six);
        b7=findViewById(R.id.seven);
        b8=findViewById(R.id.eight);
        b9=findViewById(R.id.nine);
        bplus=findViewById(R.id.plus);
        bminus=findViewById(R.id.minus);
        number = findViewById(R.id.total);
        buttonEqual = findViewById(R.id.equals);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "one is clicked", Toast.LENGTH_SHORT).show();
                number.setText(number.getText()+"1");

            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number == null) {
                    number.setText("");
                }
                else{
                    mValueOne = Float.parseFloat(number.getText()+ "");
                    cal_add=true;
                    number.setText(null);
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(number.getText()+"");
                if(cal_add==true){
                    number.setText(mValueOne+mValueTwo+"");
                    cal_add = false;
                }
            }
        });





    }
}

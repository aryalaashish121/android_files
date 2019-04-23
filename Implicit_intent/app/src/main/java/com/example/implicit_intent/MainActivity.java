package com.example.implicit_intent;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button one,two,three,four,five,six,seven,eight,nine,call,astric,hash;
    TextView textdisplay;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        hash = findViewById(R.id.hash);
        astric = findViewById(R.id.astric);
        call = findViewById(R.id.call);

        textdisplay = findViewById(R.id.txtdisplay);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        hash.setOnClickListener(this);
        astric.setOnClickListener(this);
        call.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        onBackPress();
            }

            public void onBackPress(){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Do you want to exit? ").setTitle("Exit").setCancelable(false).
                        setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+textdisplay.getText().toString()));
                                startActivity(intent);
                            }
                        }).setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }

    @Override
    public void onClick(View v) {



        if(v==one){
            value =(textdisplay.getText()+"");
            textdisplay.setText(value+"1");
        }
        if(v==two){
            value =(textdisplay.getText()+"");
            textdisplay.setText(value+"2");
        }
        if(v==three){
            value =(textdisplay.getText()+"");
            textdisplay.setText(value+"3");
        }
        if(v==four){
            value =(textdisplay.getText()+"");
            textdisplay.setText(value+"4");
        }
        if(v==five){
            value =(textdisplay.getText()+"");
            textdisplay.setText(value+"5");
        }
        if(v==six){
            value =(textdisplay.getText()+"");
            textdisplay.setText(value+"6");
        }
        if(v==seven){
            value =(textdisplay.getText()+"");
            textdisplay.setText(value+"7");
        }
        if(v==eight){
            value =(textdisplay.getText()+"");
            textdisplay.setText(value+"8");
        }
        if(v==nine){
            value=(textdisplay.getText()+"");
            textdisplay.setText(value+"9");
        }

        if(v==hash){
            //for progress dialog
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Number remove");
            progressDialog.setMessage("Please wait....");
            progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
            progressDialog.setCanceledOnTouchOutside(true);
            progressDialog.setCancelable(true);
            progressDialog.show();

            //for clearing from back side of displayed numbers.
           String str = textdisplay.getText().toString();
           if(str.length()>=1){
               str = str.substring(0,str.length()-1);
               textdisplay.setText(str);
           }
           else{
               textdisplay.setText("0");
           }
        }

        if(v==astric){
            textdisplay.append("#");
        }
        if(v==call){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to call ").setTitle("Phone call").setCancelable(false).
                    setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+textdisplay.getText().toString()));
                            startActivity(intent);
                        }
                    }).setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
            }
        }
}




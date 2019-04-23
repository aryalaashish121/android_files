package com.example.edittext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button btn_send,btn_save,btn_clear;
    TextView textView;
    String name;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.text);
        textView = findViewById(R.id.newtext);
        btn_send = findViewById(R.id.btn_send);
        btn_save = findViewById(R.id.btn_save);
        btn_clear = findViewById(R.id.btn_clear);


        btn_send.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        preferences = getSharedPreferences("App", Context.MODE_PRIVATE);
        editor = preferences.edit();



    }

    @Override
    public void onClick(View v) {
       if(v.getId()==R.id.btn_save){
           if(!TextUtils.isEmpty(editText.getText().toString())){
               name = editText.getText().toString();
               editor.putString("Name",name);
               editor.commit();
               Toast.makeText(this, "Value saved sucessfully !", Toast.LENGTH_SHORT).show();
           }
           else{
               Toast.makeText(this, "Value cannot be empty!", Toast.LENGTH_SHORT).show();
           }
       }

       else if(v.getId()==R.id.btn_send){
           Toast.makeText(this, preferences.getString("Name","Null"), Toast.LENGTH_SHORT).show();
       }
       else if(v.getId()==R.id.btn_clear){
           //editor.putString("Name","");
           //editor.commit();
           editor.remove("Name").commit();
           Toast.makeText(this, "Your value is cleared. Now you can save other value.", Toast.LENGTH_SHORT).show();

       }
    }
}
//using flag to create simple login system..

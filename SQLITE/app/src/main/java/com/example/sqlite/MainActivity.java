package com.example.sqlite;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etword,etmeaning;
    Button btnsave,btnload;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave = findViewById(R.id.btn_save_meaning);
        btnload = findViewById(R.id.btn_get_meaning);

        etword = findViewById(R.id.et_word);
        etmeaning = findViewById(R.id.et_meaning);

        //setting action listner
        btnload.setOnClickListener(this);
        btnsave.setOnClickListener(this);
        
        dbHelper = new DatabaseHelper(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_save_meaning){
        
            if((!TextUtils.isEmpty(etword.getText().toString()))&&!TextUtils.isEmpty(etmeaning.getText().toString())){
               boolean saved = dbHelper.saveDictionary(
                       new Dictionary(etword.getText().toString(),
                               etmeaning.getText().toString()),
                       dbHelper.getWritableDatabase()
               );
               if(saved){
                   Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
               }

            }else{
                Toast.makeText(this, "Enter Both Word and Meaning", Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId()==R.id.btn_get_meaning){

            List<Dictionary> dictionaryList =dbHelper.getDictionary(dbHelper.getReadableDatabase());
            if(dictionaryList.size()>0){
                for(Dictionary dict :dictionaryList){
                    Log.d("SQLITE--->",dict.getWord()+ "==="+dict.getMeaning());
                }
                Toast.makeText(this, "Data Fetched Sucesfully..", Toast.LENGTH_SHORT).show();
            }
            
        }
    }
}

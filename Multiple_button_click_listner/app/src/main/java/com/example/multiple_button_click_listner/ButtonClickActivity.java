package com.example.multiple_button_click_listner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ButtonClickActivity extends AppCompatActivity {
String name,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        name=getIntent().getStringExtra("NAME");
        username=getIntent().getStringExtra("USERNAME");
        Toast.makeText(this, "Name\t "+name+"\nUsername \t"+username, Toast.LENGTH_SHORT).show();
    }
}

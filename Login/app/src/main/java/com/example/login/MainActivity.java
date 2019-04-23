package com.example.login;

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
    EditText username, password;
    Button login;
    int counter = 5;
    String user_name,pass_word;
    TextView txtinfo;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        txtinfo = findViewById(R.id.txtinfo);

        login.setOnClickListener(this);
        preferences = getSharedPreferences("App", Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        if (!TextUtils.isEmpty(username.getText().toString()) || !TextUtils.isEmpty(password.getText().toString())) {
            user_name = username.getText().toString();
            pass_word = password.getText().toString();
            validate(user_name,pass_word);
        }
        else{
            Toast.makeText(this, "Both username and password cannot be empty!", Toast.LENGTH_SHORT).show();
        }
    }

    public void validate(String username, String password){

        if((username.equals("admin"))&&(password.equals("admin"))){

            editor.putString("username",user_name);
            editor.putString("password",pass_word);
            editor.commit();

            Intent intent = new Intent(MainActivity.this,Home_Activity.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(this, "Your username or password incorrect!", Toast.LENGTH_SHORT).show();
            txtinfo.setText("You have "+(counter-1)+" more chance..");
            counter--;
        }

        if(counter==0){
            login.setEnabled(false);
            txtinfo.setText("Your account is locked!");
        }
        
    }
}

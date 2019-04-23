package com.example.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtusername,txtpassword;
    Button bsbumit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtusername=findViewById(R.id.username);
        txtpassword=findViewById(R.id.password);
        bsbumit=findViewById(R.id.btnsubmit);

        bsbumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    Toast.makeText(MainActivity.this, txtusername.getText().toString()+txtpassword.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            private boolean validate(){
                if(TextUtils.isEmpty(txtusername.getText().toString())){
                    txtusername.setError("Enter Username");
                    txtusername.requestFocus();
                    return false;
                }
                else if (TextUtils.isEmpty(txtpassword.getText().toString())){
                    txtpassword.setError("Enter Password");
                    txtpassword.requestFocus();
                    return false;
                }
                else{
                    return true;
                }
            }
        });
    }
}

package com.example.mydbapplication.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mydbapplication.Database.DatabaseHelper;
import com.example.mydbapplication.Model.Student;
import com.example.mydbapplication.R;

public class AddStudentInfo extends AppCompatActivity {

    EditText etName,etEmail,etPhone,etImage;
    Button btnInsert;
    String mode ="add";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_add_student_info);

        etName = findViewById(R.id.std_name);
        etEmail = findViewById(R.id.std_email);
        etPhone = findViewById(R.id.std_number);
        etImage = findViewById(R.id.std_image);

        btnInsert = findViewById(R.id.btn_add);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            etName.setText(bundle.getString("STUDENT_NAME"));
            etPhone.setText(bundle.getString("STUDENT_PHONE"));
            etEmail.setText(bundle.getString("STUDENT_EMAIL"));
            etImage.setText(bundle.getString("STUDENT_IMAGE"));
        }

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mode=="add"){
                    DatabaseHelper db = new DatabaseHelper(AddStudentInfo.this);
                    String std_name = etName.getText().toString();
                    String std_email = etEmail.getText().toString();
                    String std_phone = etPhone.getText().toString();
                    String std_image = etImage.getText().toString();

                    long id = db.AddStudentInfo(new Student(0,std_name,std_phone,std_email,std_image));
                    Toast.makeText(AddStudentInfo.this, "Added"+String.valueOf(id), Toast.LENGTH_SHORT).show();
                }
                else{



                }
                }

        });
    }
}

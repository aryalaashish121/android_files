package com.example.mydbapplication.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.mydbapplication.Database.DatabaseHelper;
import com.example.mydbapplication.Model.Student;
import com.example.mydbapplication.Model.StudentAdapter;
import com.example.mydbapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button add,update,delete;
    RecyclerView recyclerView;
    List<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //calling recycler view
        recyclerView = findViewById(R.id.rvstudent);

        add = findViewById(R.id.btn_adding);
        update = findViewById(R.id.btn_edit);
        delete = findViewById(R.id.btn_Delete);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddStudentInfo.class);
                startActivity(intent);
            }
        });

        DatabaseHelper db = new DatabaseHelper(this);
        students = db.GetStudents();
        StudentAdapter studentAdapter = new StudentAdapter(students,this);
        recyclerView.setAdapter(studentAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



}

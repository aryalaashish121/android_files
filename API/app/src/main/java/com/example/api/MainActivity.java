package com.example.api;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.api.Model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button btn_search;
    Button btn_show;
    private TextView displayEmployees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_search = findViewById(R.id.am_bt_search);
        btn_show = findViewById(R.id.am_bt_show);
        displayEmployees = findViewById(R.id.tvData);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = new Intent(MainActivity.this, SearchActivity.class);

                startActivity(search);
            }
        });
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://dummy.restapiexample.com/api/v1/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                EmpAPI empAPI = retrofit.create(EmpAPI.class);

                Call<List<Employee>> listCall = empAPI.getEmployee();

                listCall.enqueue(new Callback<List<Employee>>() {
                    @Override
                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {

                        if (!response.isSuccessful()) {
                            displayEmployees.setText("Code : " + response.code());
                            return;
                        }
                        List<Employee> employeeList = response.body();
                        for (Employee employee : employeeList) {
                            String content = "";
                            content += "ID : " + employee.getId() + "\n";
                            content += "employee_name : " + employee.getEmployee_name() + "\n";
                            content += "employee_salary : " + employee.getEmployee_salary() + "\n";
                            content += "employee_age : " + employee.getEmployee_age() + "\n";
                            content += "profile_image : " + employee.getProfile_image() + "\n";
                            content += "--------------------------------------------------------" + "\n";

                            displayEmployees.append(content);

                        }
                    }

                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable t) {
                        displayEmployees.setText("Error " + t.getMessage());
                    }
                });

            }
        });
    }

}

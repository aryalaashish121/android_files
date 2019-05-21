package com.example.api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.api.Model.Employee;
import com.example.api.Model.EmployeeCU;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
        EditText ename,eage,esalary,esearch;
        Button bt_Search,bt_Add;
        EmpAPI empAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ename = findViewById(R.id.et_name);
        eage = findViewById(R.id.et_age);
        esalary = findViewById(R.id.et_salary);
        esearch = findViewById(R.id.et_search);
        bt_Search = findViewById(R.id.bt_search);
        bt_Add = findViewById(R.id.btn_update);

        bt_Add.setOnClickListener(this);
        bt_Search.setOnClickListener(this);

        }
        private void creatInstance(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://dummy.restapiexample.com/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            empAPI = retrofit.create(EmpAPI.class);
        }

        private void addEmployee(){
        creatInstance();
            Call<Void> addcall = empAPI.addEmployee(
                    new EmployeeCU(0,
                            ename.getText().toString(),
                            esalary.getText().toString(),
                            eage.getText().toString()));
            addcall.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Toast.makeText(SearchActivity.this, "ADDED..", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(SearchActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_search){
            bt_Add.setText("UPDATE");
           loadData();
           if(v.getId()==R.id.btn_update){
               updateData();
           }
        }
        else if(v.getId()==R.id.btn_update) {
            bt_Add.setText("ADD");
            addEmployee();

        }
    }
    private void loadData(){
       creatInstance();

        Call<Employee> listCall = empAPI.getEmployeeById(Integer.parseInt(esearch.getText().toString()));
        listCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Toast.makeText(SearchActivity.this, "value"+response.body().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(SearchActivity.this, "Name:"+response.body().getEmployee_name(), Toast.LENGTH_SHORT).show();
                ename.setText(response.body().getEmployee_name());
                eage.setText(response.body().getEmployee_age());
                esalary.setText(response.body().getEmployee_salary());
                Toast.makeText(SearchActivity.this, "value is: "+esearch.getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateData(){
        EmployeeCU employeeCU = new EmployeeCU(Integer.parseInt(esearch.getText().toString()),ename.getText().toString(),
                esalary.getText().toString(),
                eage.getText().toString()
        );
        Call<Void> voidCall = empAPI.update(Integer.parseInt(esearch.getText().toString()),employeeCU);
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(SearchActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "Error Updating..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

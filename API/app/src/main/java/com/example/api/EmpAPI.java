package com.example.api;

import com.example.api.Model.Employee;
import com.example.api.Model.EmployeeCU;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmpAPI {

    @GET ("employees")
    Call<List<Employee>> getEmployee();

    @GET("employee/{empID}")
    Call<Employee> getEmployeeById(@Path("empID") int empId);

    @PUT("update/{id}")
    Call<Void> update(@Path("id") int id,@Body EmployeeCU employeeCU);

    @POST("create")
    Call<Void> addEmployee(@Body EmployeeCU employeeCU);

    @DELETE("delete/{id}")
    Call <Void> deleteEmployee(@Path("id") int id);


}

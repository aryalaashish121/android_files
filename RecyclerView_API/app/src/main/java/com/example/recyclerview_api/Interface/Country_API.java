package com.example.recyclerview_api.Interface;

import com.example.recyclerview_api.Model.Countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Country_API {

    @GET("flags")
    Call<List<Countries>> getCountries();

    @GET("singleflag/{id}")
    Call<Countries> getCountryById(@Path("id") int id);

}


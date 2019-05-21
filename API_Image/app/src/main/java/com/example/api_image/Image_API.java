package com.example.api_image;

import com.example.api_image.Model.Countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Image_API {

    @GET("flags")
    Call<List<Countries>> getCountries();

    @GET("singleflag/{id}")
    Call<Countries> getCountryById (@Path("id") int id);

}

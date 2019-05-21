package com.example.api_image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.api_image.Model.Countries;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText id;
    Button show;
    TextView countryName;
    ImageView countryImage;
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id=findViewById(R.id.inputId);
        show=findViewById(R.id.showCountries);
        countryName=findViewById(R.id.displayCountryName);
        countryImage=findViewById(R.id.countryImage);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadCountries();
            }
        });


    }

    private void loadCountries()
    {
        retrofit=new Retrofit.Builder()
                .baseUrl("http://sujitg.com.np/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Image_API image_api=retrofit.create(Image_API.class);

        Call<Countries> countriesCall=image_api.getCountryById(Integer.parseInt(id.getText().toString()));

        countriesCall.enqueue(new Callback<Countries>() {
            @Override
            public void onResponse(Call<Countries> call, Response<Countries> response) {

                countryName.setText(response.body().getCountry());
                String imgPath="http://sujitg.com.np/wc/teams/"+ response.body().getFile();
                loadImage(imgPath);
            }

            @Override
            public void onFailure(Call<Countries> call, Throwable t) {

            }
        });
    }

    private void StrictMode()
    {
       android.os.StrictMode.ThreadPolicy policy= new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
       android.os.StrictMode.setThreadPolicy(policy);
    }

    private void loadImage(String imgPath)
    {
        try {
            URL url=new URL(imgPath);
            Bitmap bitmap=BitmapFactory.decodeStream((InputStream)url.getContent());
            countryImage.setImageBitmap(bitmap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

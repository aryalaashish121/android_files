package com.example.string_array;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] countries;
    String name;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.txtdisplay);

        name=getResources().getString(R.string.mystring);
        Toast.makeText(this, "College name is: "+countries, Toast.LENGTH_SHORT).show();

        countries=getResources().getStringArray(R.array.country);
        for(int i=0;i<countries.length;i++){
            Toast.makeText(this, "\n"+countries[i], Toast.LENGTH_SHORT).show();
         


            //Log.d("countries", countries[i]);
        }

    }
}

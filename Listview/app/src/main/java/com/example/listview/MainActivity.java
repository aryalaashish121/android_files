package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] country={"Nepal","Japan","USA","South Korea","China","Singapur","Austria","Austrila","Balli"
    ,"Nepal","Japan","USA","South Korea","China","Singapur","Austria","Austrila","Balli"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_country);
        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,R.layout.sample_layout,country);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}


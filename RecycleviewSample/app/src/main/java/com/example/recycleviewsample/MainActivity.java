package com.example.recycleviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Animalmodule> animalList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        prepareAnimalList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AnimalAdapter(animalList, getApplicationContext()));
    }

    public void prepareAnimalList() {
        animalList.add(new Animalmodule("deer", R.mipmap.ic_launcher_round));
        animalList.add(new Animalmodule("bear", R.mipmap.ic_launcher));
        animalList.add(new Animalmodule("deer", R.mipmap.ic_launcher));
        animalList.add(new Animalmodule("deer", R.mipmap.ic_launcher));
    }
}
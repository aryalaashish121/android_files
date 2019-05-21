package com.example.online_clothing;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Drashboard extends AppCompatActivity implements ItemsAdapter.OnItemListener {

    TextView displayUsername;
    Button btnLogout,btnadd;
    String dUsername,iName,iPrice,iDesc;
    private RecyclerView recyclerView;
    List<Items> itemsList=new ArrayList<>();
    String item;
    Integer image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drashboard);
        displayUsername = findViewById(R.id.getUsername);
        btnLogout = findViewById(R.id.logout);
        btnadd = findViewById(R.id.add_products);

        dUsername = getIntent().getStringExtra("USERNAME");
        displayUsername.setText(dUsername);

        recyclerView = findViewById(R.id.recyclerView);
        fetchItems();

        recyclerView.setAdapter(new ItemsAdapter(itemsList,getApplicationContext(),this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(Drashboard.this,MainActivity.class);
                startActivity(logout);
            }
        });


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent products = new Intent(Drashboard.this,AddProducts.class);
                startActivity(products);
            }
        });

        }

    @Override
    public void onItemClick(int position) {
        iName=itemsList.get(position).getItemName();
        iPrice=itemsList.get(position).getItemPrice();
        iDesc=itemsList.get(position).getItemDescription();
        image=itemsList.get(position).getItemImage();
        Intent openDescription=new Intent(Drashboard.this,Product_description.class);
        openDescription.putExtra("name",iName);
        openDescription.putExtra("price",iPrice);
        openDescription.putExtra("desc",iDesc);
        openDescription.putExtra("image",image);
        startActivity(openDescription);
    }

    private void fetchItems()
    {
        try {
            FileInputStream fis=openFileInput("items.txt");
            InputStreamReader ir=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(ir);

            while ((item=br.readLine())!=null)
            {
                String [] itemDetails=item.split("->");
                String itemImage=itemDetails[2];
                int res=getResources().getIdentifier(itemImage,"drawable",getPackageName());
                itemsList.add(new Items(itemDetails[0],itemDetails[1],res,itemDetails[3]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


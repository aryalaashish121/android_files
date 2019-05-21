package com.example.online_clothing;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Product_description extends AppCompatActivity {

    TextView itemName,itemPrice,itemDesc;
    ActionBar actionBar;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

        itemName=findViewById(R.id.displayItemName);
        itemPrice=findViewById(R.id.displayItemPrice);
        itemDesc=findViewById(R.id.displayItemDesc);
        image=findViewById(R.id.displayImage);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Description of Item");


        Bundle bundle=getIntent().getExtras();

        if(bundle != null)
        {
            itemName.setText(bundle.getString("name"));
            itemPrice.setText(bundle.getString("price"));
            itemDesc.setText(bundle.getString("desc"));
            image.setImageResource(bundle.getInt("image"));
        }
    }
}

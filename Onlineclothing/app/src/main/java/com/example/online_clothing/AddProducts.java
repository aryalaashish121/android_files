package com.example.online_clothing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class AddProducts extends AppCompatActivity {
    private static final String FILE_NAME="items.txt";
    EditText product_name,product_price,product_image,product_desc;
    Button btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);

        product_name = findViewById(R.id.product_name);
        product_price = findViewById(R.id.product_price);
        product_desc = findViewById(R.id.product_desc);
        product_image = findViewById(R.id.product_image);
        btn_add = findViewById(R.id.add_product);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(product_name.getText().toString()))
                {
                    product_name.setError("Please enter item name");
                    product_name.requestFocus();
                }
                else if(TextUtils.isEmpty(product_price.getText().toString()))
                {
                    product_price.setError("Please enter price of the item");
                    product_price.requestFocus();
                }
                else if(TextUtils.isEmpty(product_image.getText().toString()))
                {
                    product_image.setError("Please enter image name of the item");
                    product_image.requestFocus();
                }
                else if (TextUtils.isEmpty(product_desc.getText().toString()))
                {
                    product_desc.setError("Please enter item description");
                    product_desc.requestFocus();
                }
                else
                {
                    save_proudcts();
                }

            }

        });
    }

    private void save_proudcts(){
        try{
            String pname = product_name.getText().toString();
            String pprice = product_price.getText().toString();
            String pdesc = product_desc.getText().toString();
            String pimage = product_image.getText().toString();

            PrintStream printStream=new PrintStream(openFileOutput("items.txt",MODE_PRIVATE|MODE_APPEND));
            printStream.println(product_name.getText().toString()+"->"+product_price.getText().toString()+"->"
                    +product_image.getText().toString()+"->"+product_desc.getText().toString());
            Toast.makeText(AddProducts.this, "Added successfully to.."+getFilesDir(), Toast.LENGTH_SHORT).show();
            product_name.setText(null);
            product_image.setText(null);
            product_desc.setText(null);
            product_price.setText(null);
        }catch (FileNotFoundException e){

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

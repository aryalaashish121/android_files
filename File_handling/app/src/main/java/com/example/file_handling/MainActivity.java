package com.example.file_handling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "myfile.txt";
    EditText editText;
    Button btnsave, btnload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.text);
        btnsave = findViewById(R.id.btnsave);
        btnload = findViewById(R.id.btnload);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String text = editText.getText().toString();
                    FileOutputStream fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
                    fos.write(text.getBytes());
                    fos.close();
                    Toast.makeText(MainActivity.this, "Saved to: "+getFilesDir()+"/"+FILE_NAME, Toast.LENGTH_SHORT).show();
                    editText.setText("");
                }catch (FileNotFoundException e){

                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String data;
                    FileInputStream fis = openFileInput(FILE_NAME);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    while ((data = br.readLine())!=null){
                        sb.append(data).append("\n");
                    }
                    editText.setText(sb.toString());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}

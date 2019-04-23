package com.example.register;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ActionBar abbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abbar=getSupportActionBar();
        abbar.setTitle("Products");



    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_menu,menu);
        return super.onCreateOptionsMenu(menu);
        
       
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_menu_setting:
                Toast.makeText(this, "Setting menu is selected", Toast.LENGTH_SHORT).show();
                break;
                
            case R.id.action_menu_audio:
                Toast.makeText(this, "Audio option is clicked", Toast.LENGTH_SHORT).show();
        }
        
        return super.onOptionsItemSelected(item);
    }

   // UserDetails userDetails = new UserDetails();
}


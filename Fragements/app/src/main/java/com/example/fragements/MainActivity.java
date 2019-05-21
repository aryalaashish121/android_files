package com.example.fragements;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_click;
    Layout relative;
    boolean status;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_click = findViewById(R.id.button);
        setContentView(R.layout.fragment_blank);
        btn_click.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(status){
            BlankFragment frag1 = new BlankFragment();
            fragmentTransaction.replace(R.id.fragement_blank,frag1);
            fragmentTransaction.commit();
            btn_click.setText("Load fragment 2");
            status =false;
        }
        else{
            fragment2 frag2 = new fragment2();
            fragmentTransaction.replace(R.id.fragement_blank,frag2);
            fragmentTransaction.commit();
            btn_click.setText("Load Fragment 1");
            status = true;
        }
    }
}

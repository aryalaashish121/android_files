package com.example.online_shopping;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginRegister extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private TabLayout layoutcontainer;

    EditText l_email,l_password,r_email,r_name,r_password;
    TextView link_signup, link_login;
    Button btn_login,btn_register;
    private boolean status =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        layoutcontainer = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());

        adapter.addFragment(new Login(), "Login");
        adapter.addFragment(new Register(), "Register");

        viewPager.setAdapter(adapter);
        layoutcontainer.setupWithViewPager(viewPager);


    }

    @Override
    public void onClick(View v) {

    }
}

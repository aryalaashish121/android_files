package com.example.online_clothing;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {
    EditText email,password;
    Button btnlogin;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String user_email,user_password;


    public Login() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_login, container, false);

        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        btnlogin = view.findViewById(R.id.btn_login);
        getActivity().setTitle("Shop Clothing Online");

        sharedPreferences = this.getActivity().getSharedPreferences("MYAPP",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(email.getText().toString())&&!TextUtils.isEmpty(password.getText().toString())){
                   String e = email.getText().toString();
                   String p = password.getText().toString();

                    user_email =  sharedPreferences.getString("REG_EMAIL",e);
                    user_password = sharedPreferences.getString("REG_PASSWORD",p);
                    editor.commit();

                    if(e.equals(user_email)&&p.equals(user_password))
                    {
                        editor.putString("USERNAME",e);
                        Intent drashboard = new Intent(getActivity(),Drashboard.class);
                        drashboard.putExtra("USERNAME",e);
                        startActivity(drashboard);
                    }
                    else {
                        Toast.makeText(getActivity(), "Invaild Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }
                if (TextUtils.isEmpty(email.getText().toString()))
                {
                    email.setError("Please enter username");
                    email.requestFocus();
                }
                else if(TextUtils.isEmpty(password.getText().toString()))
                {
                    password.setError("Please enter password");
                    password.requestFocus();
                }
            }
        });


        return view;



    }



}

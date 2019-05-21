package com.example.online_clothing;


import android.content.Context;
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
public class Register extends Fragment {
    EditText name,email,password;
    Button btn_signup;
    String useremail,userpassword;
    SharedPreferences preferences;
    SharedPreferences.Editor editorSignup;

    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        name = view.findViewById(R.id.input_name);
        email = view.findViewById(R.id.input_email);
        password = view.findViewById(R.id.input_password);
        btn_signup = view.findViewById(R.id.btn_signup);

        preferences = this.getActivity().getSharedPreferences("MYAPP", Context.MODE_PRIVATE);
        editorSignup = preferences.edit();

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(name.getText().toString()))
                {
                    name.setError("Please Enter Your Name..");
                    name.requestFocus();
                }
                else if(TextUtils.isEmpty(email.getText().toString()))
                {
                    email.setError("Please enter your vailed email..");
                    email.requestFocus();
                }
                else if(TextUtils.isEmpty(password.getText().toString()))
                {
                    password.setError("Please Enter your password");
                    password.requestFocus();
                }
                else {
                    String reg_email = email.getText().toString();
                    String reg_password = password.getText().toString();
                    String reg_name = name.getText().toString();
                    Toast.makeText(getActivity(), "Registred sucessfully.", Toast.LENGTH_SHORT).show();
                    editorSignup.putString("REG_EMAIL",reg_email);
                    editorSignup.putString("REG_PASS",reg_password);
                    editorSignup.putString("REG_NAME",reg_name);
                    editorSignup.commit();

                    email.setText("");
                    name.setText("");
                    password.setText("");

                }
            }
        });

        return view;
    }

}

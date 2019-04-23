package com.example.calender;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView txtdate;
    Button button;
    Calendar calendar;
    int day,month,year;
    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener listner;
    TextView result;
  //Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtdate = findViewById(R.id.cal);
        button = findViewById(R.id.btn);
        result = findViewById(R.id.disCalender);
       txtdate.setOnClickListener(this);
        calendar = Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        setDate(year, month+1,day);

        listner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                setDate(year,month+1,dayOfMonth);
               }
        };
        datePickerDialog = new DatePickerDialog(this,listner,year,month+1,day);

    }
    public void setDate(int day, int month, int year){
      txtdate.setText(day+"/"+month+"/"+year);
      result.setText(day+"/"+month+"/"+year);
    }

    @Override
    public void onClick(View v) {
        datePickerDialog.show();
    }


}

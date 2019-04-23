package com.example.cars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText car_Name, manu_year, car_Color, car_Price, engine_Capacity;
    TextView dis_cars;
    Button btn_add_Car;
    Car_Controller car=new Car_Controller();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        car_Name =findViewById(R.id.car_name);
        manu_year =findViewById(R.id.manufacture_year);
        car_Color =findViewById(R.id.car_color);
        car_Price =findViewById(R.id.car_price);
        engine_Capacity =findViewById(R.id.engine_Capacity);
        dis_cars =findViewById(R.id.output);
        btn_add_Car =findViewById(R.id.add_Cars);

        car.setName(car_Name.getText().toString());
        car.setYear(manu_year.getText().toString());
        car.setColor(car_Color.getText().toString());
        car.setPrice(car_Price.getText().toString());
        car.setEngine(engine_Capacity.getText().toString());
        btn_add_Car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(car_Name.getText().toString())) {
                    car_Name.setError("Car name cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(manu_year.getText().toString())) {
                    manu_year.setError("Manufactured year cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(car_Color.getText().toString())) {
                    car_Color.setError("Colour of car cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(car_Price.getText().toString())) {
                    car_Price.setError("Price of car cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(engine_Capacity.getText().toString())) {
                    engine_Capacity.setError("Engine size of car cannot be empty");
                    return;
                }
                else {
                    dis_cars.append("Car Name: " + car_Name.getText().toString() + "\n");
                    dis_cars.append("Manufactured Year: " + manu_year.getText().toString() + "\n");
                    dis_cars.append("Colour: " + car_Color.getText().toString() + "\n");
                    dis_cars.append("Purchased Price (Rs.): " + car_Price.getText().toString() + "\n");
                    dis_cars.append("Engine Size (Ltrs.): " + engine_Capacity.getText().toString() + "\n");
                }
            }
        });
    }
}

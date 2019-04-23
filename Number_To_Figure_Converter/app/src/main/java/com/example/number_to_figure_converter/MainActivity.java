package com.example.number_to_figure_converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText user_Number;
    private TextView display_Words;
    private Button btn_Convert;
    private String[] ones = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
        setAction();
    }
    private void initiate()
    {
        user_Number =findViewById(R.id.user_number);
        display_Words =findViewById(R.id.display_figure);
        btn_Convert =findViewById(R.id.btn_convert);
    }
    private void setAction()
    {
        btn_Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int input = Integer.parseInt(user_Number.getText().toString());
                Model model = new Model(ones,tens);
                if (input < 20) {

                    display_Words.setText(model.getOnes()[input]);
                } else if (input < 100) {
                    int tensIndex = input / 10;
                    int onesIndex = input % 10;

                    if (onesIndex != 0) {
                        display_Words.setText(model.getTens()[tensIndex] + " " + model.getOnes()[onesIndex]);
                    } else {
                        display_Words.setText(model.getTens()[tensIndex]);
                    }
                } else {
                    int hundredsIndex = input / 100;
                    int remainder = input % 100;
                    int tensIndex = remainder / 10;
                    int onesIndex = remainder % 10;

                    if (onesIndex != 0) {
                        display_Words.setText(model.getOnes()[hundredsIndex] + " Hundred " + model.getTens()[tensIndex] + " " +
                                model.getOnes()[onesIndex]);
                    } else {
                        display_Words.setText(model.getOnes()[hundredsIndex] + " Hundred " + model.getTens()[tensIndex]);
                    }

                }
            }});
    }

}

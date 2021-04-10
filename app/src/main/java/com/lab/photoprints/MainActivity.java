package com.lab.photoprints;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    RadioGroup radioGroup;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.main_no);
        radioGroup = findViewById(R.id.main_radioGroup);
        button = findViewById(R.id.main_btn);
        textView = findViewById(R.id.main_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = radioGroup.getCheckedRadioButtonId();
                if(id== R.id.main_1){
                    showPrice(19);
                }else   if(id== R.id.main_2){
                    showPrice(49);
                }else{
                    showPrice(79);
                }
            }
        });


    }

    public void showPrice(int cents){
        double totalCents = Double.parseDouble(cents+"") * Integer.parseInt(editText.getText().toString());
        double dollar = totalCents/100;
        DecimalFormat df = new DecimalFormat("###.##");
        textView.setText("The Order cost is $" + df.format(dollar));
        textView.setVisibility(View.VISIBLE);
    }
}
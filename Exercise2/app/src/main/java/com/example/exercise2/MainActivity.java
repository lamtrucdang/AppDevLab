package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton btn_red = findViewById(R.id.btn_red);
        RadioButton btn_green = findViewById(R.id.btn_green);
        RadioButton btn_blue = findViewById(R.id.btn_blue);
        RadioButton btn_gray = findViewById(R.id.btn_gray);
        LinearLayout bg = findViewById(R.id.bg);

        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg.setBackgroundColor(Color.RED);
            }
        });
        btn_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg.setBackgroundColor(Color.GREEN);
            }
        });
        btn_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg.setBackgroundColor(Color.BLUE);
            }
        });
        btn_gray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg.setBackgroundColor(Color.GRAY);
            }
        });
    }
}
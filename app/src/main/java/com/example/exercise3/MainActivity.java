package com.example.exercise3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button checkTime = (Button) findViewById(R.id.checkTime);
        final AlertDialog ad=new AlertDialog.Builder(this).create();

        checkTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date t = new Date();
                String message="Current time: " + t.toLocaleString();
                ad.setMessage(message);
                ad.show();
            }
        });
    }
}
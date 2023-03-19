package com.example.exercise4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textInput = (EditText) findViewById(R.id.text_Input);
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        textInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if (keyEvent.getAction() == keyEvent.ACTION_DOWN && (i == keyEvent.KEYCODE_BACK))
                {
                    String message = textInput.getText().toString();
                    alertDialog.setMessage(message);
                    alertDialog.show();

                    return true;
                }
                return false;
            }
        });
    }
}
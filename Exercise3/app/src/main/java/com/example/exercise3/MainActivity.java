package com.example.exercise3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    View.OnClickListener buttonListener;
    EditText tvresult;
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_plus, btn_minus, btn_multi, btn_divide, btn_result, btn_reset;
    Integer lastvalue = 0,currentvalue;
    String operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvresult = (EditText) findViewById(R.id.text);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multi = (Button) findViewById(R.id.btn_multi);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_result = (Button) findViewById(R.id.btn_result);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                switch (btn.getId()) {
                    case R.id.btn_0:
                        setvalue(tvresult, "0");
                        break;
                    case R.id.btn_1:
                        setvalue(tvresult, "1");
                        break;
                    case R.id.btn_2:
                        setvalue(tvresult, "2");
                        break;
                    case R.id.btn_3:
                        setvalue(tvresult, "3");
                        break;
                    case R.id.btn_4:
                        setvalue(tvresult, "4");
                        break;
                    case R.id.btn_5:
                        setvalue(tvresult, "5");
                        break;
                    case R.id.btn_6:
                        setvalue(tvresult, "6");
                        break;
                    case R.id.btn_7:
                        setvalue(tvresult, "7");
                        break;
                    case R.id.btn_8:
                        setvalue(tvresult, "8");
                        break;
                    case R.id.btn_9:
                        setvalue(tvresult, "9");
                        break;
                    case R.id.btn_plus:

                        operation = "plus";
                        break;
                    case R.id.btn_minus:
                        operation = "minus";
                        break;
                    case R.id.btn_multi:
                        operation = "multi";
                        break;
                    case R.id.btn_divide:
                        operation = "divide";
                        break;
                    case R.id.btn_result:
                        lastvalue = Integer.parseInt(tvresult.getText().toString());
                        break;
                    case R.id.btn_reset:
                        resetvalue();
                        break;
                }
            }
        };

        btn_0.setOnClickListener(buttonListener);
        btn_1.setOnClickListener(buttonListener);
        btn_2.setOnClickListener(buttonListener);
        btn_3.setOnClickListener(buttonListener);
        btn_4.setOnClickListener(buttonListener);
        btn_5.setOnClickListener(buttonListener);
        btn_6.setOnClickListener(buttonListener);
        btn_7.setOnClickListener(buttonListener);
        btn_8.setOnClickListener(buttonListener);
        btn_9.setOnClickListener(buttonListener);
        btn_plus.setOnClickListener(buttonListener);
        btn_minus.setOnClickListener(buttonListener);
        btn_multi.setOnClickListener(buttonListener);
        btn_divide.setOnClickListener(buttonListener);
        btn_result.setOnClickListener(buttonListener);
        btn_reset.setOnClickListener(buttonListener);
    }

    public void setvalue(EditText a, String b){
        String last = a.getText().toString();
        if(!last.equals("0")){
            last +=b;
            b=last;
        }
        a.setText(b);
    }

    public void resetvalue(){
        tvresult.setText("0");
    }

    public Integer process(Integer a, Integer b){
        Integer presult=0;
        if (operation=="plus") {
            presult = a + b;
            tvresult.setText(presult.toString());
        }
        if (operation=="minus") {
            presult = a - b;
            tvresult.setText(presult.toString());
        }
        if (operation=="multi") {
            presult = a * b;
            tvresult.setText(presult.toString());
        }
        if (operation=="divide") {
            presult = a / b;
            tvresult.setText(presult.toString());
        }
        return presult;
    }
}
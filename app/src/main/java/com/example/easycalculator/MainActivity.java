package com.example.easycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTextview,solutionTextview;
    MaterialButton buttonC,buttonOpenBracket,buttonCloseBracket;
    MaterialButton buttonDivide,buttonMultiply,buttonPlus,buttonMinus,buttonEqual;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonAC,buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextview = findViewById(R.id.result_textview);
        solutionTextview = findViewById(R.id.solution_textview);

        assignID(buttonC,R.id.button_c);
        assignID(buttonOpenBracket,R.id.button_open_bracket);
        assignID(buttonCloseBracket,R.id.button_close_bracket);
        assignID(buttonDivide,R.id.button_divide);
        assignID(buttonMultiply,R.id.button_multiply);
        assignID(buttonPlus,R.id.button_plus);
        assignID(buttonMinus,R.id.button_minus);
        assignID(buttonEqual,R.id.button_equal);
        assignID(button0,R.id.button_0);
        assignID(button1,R.id.button_c);
        assignID(button2,R.id.button_c);
        assignID(button3,R.id.button_c);
        assignID(button4,R.id.button_c);
        assignID(button5,R.id.button_c);
        assignID(button6,R.id.button_c);
        assignID(button7,R.id.button_c);
        assignID(button8,R.id.button_c);
        assignID(button9,R.id.button_c);
        assignID(buttonAC,R.id.button_AC);
        assignID(buttonDot,R.id.button_dot);
    }

    void assignID(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataCalculate = solutionTextview.getText().toString();

        if (buttonText.equals("AC")){
            solutionTextview.setText("");
            resultTextview.setText("0");
            return;
        }

        if (buttonText.equals("=")){
            solutionTextview.setText(resultTextview.getText());
            return;
        }

        if (buttonText.equals("C")){
            dataCalculate = dataCalculate.substring(0,dataCalculate.length()-1);
        } else {
            dataCalculate = dataCalculate+buttonText;
        }
        solutionTextview.setText(dataCalculate);

        String finalResult = getResult(dataCalculate);

        if (!finalResult.equals("Err")){
            resultTextview.setText(finalResult);
        }
    }

    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if (finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        } catch (Exception e){
            return "Err";
        }
    }
}
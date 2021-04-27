package com.example.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mOperandOne;
    private EditText mOperandTwo;
    private TextView resultTextView;
    private calculator mCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculator = new calculator();
        mOperandOne = findViewById(R.id.editText1);
        mOperandTwo = findViewById(R.id.editText2);
        resultTextView = findViewById(R.id.textView);

    }

    public void add(View view) {
        String operandOne = mOperandOne.getText().toString();
        String operandTwo = mOperandTwo.getText().toString();

        double value =mCalculator.add(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        resultTextView.setText(String.valueOf(value));

        //compute(calculator.Operator.ADD);

    }

    public void sub(View view) {
        String operandOne = mOperandOne.getText().toString();
        String operandTwo = mOperandTwo.getText().toString();

        double value =mCalculator.sub(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        resultTextView.setText(String.valueOf(value));

    }

    public void mul(View view) {
        String operandOne = mOperandOne.getText().toString();
        String operandTwo = mOperandTwo.getText().toString();

        double value =mCalculator.mul(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        resultTextView.setText(String.valueOf(value));

    }

    public void div(View view) {
        String operandOne = mOperandOne.getText().toString();
        String operandTwo = mOperandTwo.getText().toString();

        double value =mCalculator.div(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        resultTextView.setText(String.valueOf(value));

    }
//
//    private void compute(calculator.Operator operator){
//        double operandOne;
//        double operandTwo;
//    }
}
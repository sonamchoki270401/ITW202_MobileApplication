package com.example.todo_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_SEND = "com.example.todo_04.MESSAGE";
    public static final int TEXT_Code = 1;
    TextView MainActivity_TextView01,MainActivity_TextView02;
    EditText sender_input;
    String sender_text,received_reply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity_TextView01 = (TextView)findViewById(R.id.MainActivity_TextView01);
        MainActivity_TextView02 = (TextView)findViewById(R.id.MainActivity_TextView02);
    }

    public void sender(View view) {
        sender_input= (EditText)findViewById(R.id.sender_input);
        sender_text = sender_input.getText().toString();
        Intent firstActivity_intent_obj = new Intent(this, secondActivity.class);
        firstActivity_intent_obj.putExtra(EXTRA_SEND, sender_text);
        startActivityForResult(firstActivity_intent_obj, TEXT_Code);
    }

    @Override
    public void onActivityResult(int requestCodee, int resultCode, Intent data) {
        super.onActivityResult(requestCodee, resultCode, data);
        if(requestCodee == TEXT_Code){
            if(resultCode == RESULT_OK){
                received_reply = data.getStringExtra(secondActivity.EXTRA_REPLY);
                MainActivity_TextView01.setVisibility(View.VISIBLE);
                MainActivity_TextView02.setText(received_reply);
            }
        }
    }
}
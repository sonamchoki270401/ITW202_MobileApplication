package com.example.todo_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.todo_04.MainActivity.EXTRA_SEND;

public class secondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.todo_04.REPLY";
    TextView sender_textReceived;
    EditText replyer_input;
    String replyer_text,received_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sender_textReceived = (TextView)findViewById(R.id.text_receive02);
        Intent secondActivity_intent_reveived = getIntent();
        received_text = secondActivity_intent_reveived.getStringExtra(EXTRA_SEND);
        sender_textReceived.setText(received_text);
    }

    public void reply(View view) {
        replyer_input =(EditText)findViewById(R.id.replyer_input);
        replyer_text = replyer_input.getText().toString();
        Intent secondActivity_intent_obj = new Intent(this , MainActivity.class);
        secondActivity_intent_obj.putExtra(EXTRA_REPLY,replyer_text);
        setResult(RESULT_OK, secondActivity_intent_obj);
        finish();
    }
}
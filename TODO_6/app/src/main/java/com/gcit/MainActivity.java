package com.gcit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.gcit.android.twoactivities.extra.MESSAGE";
    private static final String LOG_TAG = Activity.class.getSimpleName();
    private EditText mMessage;
    private static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessage = findViewById(R.id.editText1);
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
        mReplyHeadTextView = findViewById(R.id.textView3);
        mReplyTextView = findViewById(R.id.textView4);
        if (savedInstanceState != null){
            boolean isVisible =savedInstanceState.getBoolean("reply_visible");

        if(isVisible){
        mReplyHeadTextView.setVisibility(View.VISIBLE);
        mReplyTextView.setText(savedInstanceState.getString("reply_text"));
        mReplyTextView.setVisibility(View.VISIBLE);
        }
        }

    }
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(MainActivity2.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    public void SEND(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        String message = mMessage.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
        startActivityForResult(intent, TEXT_REQUEST);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        if (mReplyHeadTextView.getVisibility()== View.VISIBLE){
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text",
                    mReplyTextView.getText().toString());
        }
    }
}

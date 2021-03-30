package com.gcit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.gcit.android.twoactivities.extra.MESSAGE";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText mMessageEditText;
    private static final int TEXT_REQUEST=1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG,"--------");
        Log.d(LOG_TAG,"onCreate");
        mMessageEditText = findViewById(R.id.editText1);

    }
    public void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if( resultCode == RESULT_OK){
                String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
    public void SEND(View view)
    {
        Intent intent = new Intent(this, MainActivity2.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
        startActivityForResult( intent,TEXT_REQUEST);
    }
    public void onStart()
    {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }
    public void onResume()
    {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }
    public void onPause()
    {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }
    public void onStop()
    {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

}

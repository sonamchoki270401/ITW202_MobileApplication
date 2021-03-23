package com.gcit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     int Number = 0;
    TextView NumberCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumberCount = (TextView) findViewById(R.id.textView2);
    }

    public void ShowToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toastmessage,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        Number++;
        NumberCount.setText(Integer.toString(Number));
    }


}
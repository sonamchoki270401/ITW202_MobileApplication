package com.gcit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int i =-1, j;
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount  = findViewById(R.id.textView);
        if(savedInstanceState !=null){
            i = savedInstanceState.getInt("count");
            mShowCount.setText(toString().valueOf(i));
        }
    }

    public void CountUp(View view) {
        i++;
        mShowCount.setText(String.valueOf(i));
        j=i;

    }

    @Override
    protected void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putInt("count",j);
    }

}
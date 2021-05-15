package com.example.todo_17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mScoreText1;
    private TextView mScoreText2;
    private int mScore1;
    private int mScore2;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreText1 = (TextView) findViewById(R.id.ScoreTeam1);
        mScoreText2 = (TextView) findViewById(R.id.ScoreTeam2);
    }

    public void onDecrease(View view) {
//get the Id of the button that was clicked
        int ViewID = view.getId();
        switch (ViewID) {
            //if it was in Team 1
            case R.id.decreaseTeam1:
                //decrement the score and update the TextView
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            //if it was team 2
            case R.id.decreaseTeam2:
                mScore2--;
                mScoreText2.setText((String.valueOf(mScore2)));
                break;
        }
    }

    public void onIncrease(View view) {
        int ViewID = view.getId();
        switch (ViewID) {
            //if it was in Team 1
            case R.id.increaseTeam1:
                //increase the score and update the TextView
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            //if it was team 2
            case R.id.increaseTeam2:
                mScore2++;
                mScoreText2.setText((String.valueOf(mScore2)));
                break;
        }
    }
}

package com.example.todo_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText mEditText;
private TextView instruction, titleText, authorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editText);
        instruction = findViewById(R.id.instruction);
        titleText = findViewById(R.id.titleText);
        authorText = findViewById(R.id.authorText);
    }

    public void SearchBook(View view) {
        String queryString = mEditText.getText().toString();
        new FetchBook(titleText, authorText).execute(queryString);
//Network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {
            new FetchBook(titleText, authorText).execute(queryString);
            authorText.setText("");
            titleText.setText("Loading....");
        } else {
            if (queryString.length() == 0) {
                authorText.setText("");
                titleText.setText("please enter a search term");
            } else {
                authorText.setText("");
                titleText.setText("please check your network connection");
            }

        }
    }
}
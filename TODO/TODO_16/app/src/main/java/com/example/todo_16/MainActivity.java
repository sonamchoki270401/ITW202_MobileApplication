package com.example.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
private final LinkedList<String> mWordList = new LinkedList<>();
private RecyclerView mRecyclerView;
private WordListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < 20; i ++)
        {
            mWordList.addLast("word"+i);
        }

        mRecyclerView = findViewById(R.id.RecycleView);
        //Setting Adapter
        mAdapter = new WordListAdapter(this, mWordList); //linking with LinkedList
        mRecyclerView.setAdapter(mAdapter); //set Adapter Method
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.floating);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int wordListSize = mWordList.size();
                // Add new word to the wordList
                mWordList.addLast("word " + wordListSize);
                //notify the adapter
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });

    }
}
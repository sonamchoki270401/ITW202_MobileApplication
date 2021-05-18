package com.example.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //member variables
    private RecyclerView mRecyclerView;
    private ArrayList<Sport> mSportsData;
    private SportAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize recylerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        //set layoutmanager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        mSportsData = new ArrayList<>();

        mAdapter = new SportAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);
        initializationData();
        //TODO: This task is for Sangay
    }

    private void initializationData() {
        TypedArray sportImageResources = getResources().obtainTypedArray(R.array.sports_images);
        String[] sportsList = getResources().getStringArray(R.array.Sport_titles);
        String[] sportsInfos = getResources().getStringArray(R.array.sports_infos);
        //clear the existing data(to avoid duplication)
        mSportsData.clear();

        for (int i = 0; i<sportsList.length;i++ ){
            mSportsData.add(new Sport(sportsList[i],sportsInfos[i], sportImageResources.getResourceId(i,0)));
        }
        mAdapter.notifyDataSetChanged();
        sportImageResources.recycle();
    }
}
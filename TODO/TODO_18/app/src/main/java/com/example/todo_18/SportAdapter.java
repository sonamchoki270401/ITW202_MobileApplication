package com.example.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder> {
    private ArrayList<Sport> mSportsData;
    private android.content.Context mContextText;

    SportAdapter(Context context, ArrayList<Sport> SportData){
        this.mSportsData = SportData;
        this.mContextText = context;
    }


//    public SportAdapter(MainActivity mainActivity, ArrayList<Sport> mSportsData) {
//
//    }

    @NonNull
    @Override
    public SportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContextText).inflate(R.layout.list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportAdapter.ViewHolder holder, int position) {
        //get current sport
        Sport currentSport = mSportsData.get(position);
        //populate the textview with data
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleText = (TextView) itemView.findViewById(R.id.Title);
            mInfoText = (TextView) itemView.findViewById(R.id.newsTitle2);
            mSportImage =itemView.findViewById(R.id.image);

        }

        public void bindTo(Sport currentSport) {
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            Glide.with(mContextText).load(currentSport.getImageResources()).into(mSportImage);
        }
    }
}

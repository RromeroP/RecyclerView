package com.example.recyclerview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private WordListAdapter mAdapter;
        private TextView wordItemView;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            wordItemView.setText("Clicked! " + wordItemView.getText());
        }
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { // Inflate an item view.
        View mItemView = mInflater.inflate(R.layout.row, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position); //Retrieve the data for that position
        holder.wordItemView.setText(mCurrent); //Add the data to the view
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}


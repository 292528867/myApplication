package com.example.yk.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yk on 15/7/31.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    private String[] mDataset;

    public MyAdapter(String[] mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view, parent, false);
        ViewHolder vh = new ViewHolder((TextView)v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
          holder.mTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}

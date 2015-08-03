package com.example.yk.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yk on 15/7/31.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageView;
        public Context context;
        public ViewHolder(View v,View parent) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.name);
            mImageView =(ImageView) v.findViewById(R.id.pic);
            RecyclerView recyclerView = (RecyclerView) parent.findViewById(R.id.list);
            recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    ((recyclerViewActivity)context).startActivity(view,position);
                }
            }));
        }
    }

    private List<Actors> actorses;

    private  Context context;

    public MyAdapter(List<Actors> actorses, Context context) {
        this.actorses = actorses;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        ViewHolder vh = new ViewHolder(v,parent);
        return vh;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.mTextView.setText(mDataset[position]);
        Actors p = actorses.get(position);
        holder.context = context;
        holder.mTextView.setText(p.getName());
        holder.mImageView.setImageDrawable(context.getDrawable(p.getImageResourceId(context)));
    }

    @Override
    public int getItemCount() {
        return actorses == null?0:actorses.size();
    }



}


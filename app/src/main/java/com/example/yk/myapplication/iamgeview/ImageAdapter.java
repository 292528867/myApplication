package com.example.yk.myapplication.iamgeview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by yk on 15/6/15.
 */
public class ImageAdapter extends BaseAdapter {


    private int[] imageids = null;

    private Context context = null;


    public ImageAdapter(int[] imageids, Context context) {
        this.imageids = imageids;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageids.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return imageids[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //创建一个ImageView对象
        ImageView imageview = new ImageView(context);
        //设置图片给ImageView对象
        imageview.setImageResource(imageids[position]);
        //重新设置图片的宽高
        imageview.setScaleType(ImageView.ScaleType.FIT_XY);
        //重新设置Layout的宽高
        imageview.setLayoutParams(new Gallery.LayoutParams(360, 360));
        return imageview;
    }


    //根据距离中央的位移量，利用getScale()返回view的大小
    public float getScale(boolean focused, int offset) {
        return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
    }
}

package com.example.yk.myapplication.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.yk.myapplication.R;

public class ImageViewActivity extends Activity {

    private ZoomImageView zoomImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        zoomImageView =(ZoomImageView) findViewById(R.id.image);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);

        zoomImageView.setImage(bitmap);

    }



}

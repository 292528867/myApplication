package com.example.yk.myapplication.util;

import javax.security.auth.callback.Callback;

import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

/**
 * Created by yk on 15/6/9.
 */
public interface Upload {
    @Multipart
    @POST("viewSpot/test")
    String upload(@Part("file") TypedFile file,@Part("string") TypedString string, Callback cb);
}

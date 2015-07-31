package com.example.yk.myapplication.EM;

import com.example.yk.myapplication.EM.module.EmMessage;
import com.example.yk.myapplication.EM.module.Result;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.QueryMap;
import retrofit.mime.TypedInput;

/**
 * Created by yk on 15/7/6.
 */
public interface DoctorService {


    @Headers("Content-Type: application/json")
    @POST("/em/sendTxtMessage")
    void sendMessage(@Body TypedInput params, Callback<Result> callback);

    @GET("/em/query")
    void findAllByUser(@QueryMap Map<String,Object> filters,Callback<List<EmMessage>> callback);


}

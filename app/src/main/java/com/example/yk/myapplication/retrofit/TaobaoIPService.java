package com.example.yk.myapplication.retrofit;

import com.example.yk.myapplication.entity.Example;
import com.example.yk.myapplication.entity.Ip;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by yk on 15/6/29.
 */
public interface TaobaoIPService {

    @GET("/users/{user}")
    public void getFeed(@Path("user") String user,Callback<Ip> response);


    @GET("getIpInfo.php")
    Example getIp(@Query("ip") String ip);
}

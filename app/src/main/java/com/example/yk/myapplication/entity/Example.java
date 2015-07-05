package com.example.yk.myapplication.entity;

import com.google.gson.annotations.Expose;

/**
 * Created by yk on 15/6/29.
 */
public class Example {
    @Expose
    private Integer code;
    @Expose
    private Data data;

    /**
     *
     * @return
     * The code
     */
    public Integer getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The data
     */
    public Data getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(Data data) {
        this.data = data;
    }

}

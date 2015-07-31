package com.example.yk.myapplication.EM.module;

/**
 * Created by yk on 15/7/6.
 */
public class Result {

    /**
     * message : 文本消息发送成功
     * ret_code : 0
     * ret_values :
     */
    private String message;
    private int ret_code;
    private String ret_values;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public void setRet_values(String ret_values) {
        this.ret_values = ret_values;
    }

    public String getMessage() {
        return message;
    }

    public int getRet_code() {
        return ret_code;
    }

    public String getRet_values() {
        return ret_values;
    }
}

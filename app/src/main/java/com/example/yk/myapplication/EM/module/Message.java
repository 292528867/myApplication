package com.example.yk.myapplication.EM.module;

import java.util.List;

/**
 * Created by yk on 15/7/6.
 */
public class Message {

    /**
     * target : ["qiuqiu"]
     * from : lixuanwu
     * msg : {"type":"txt","msg":"今天是星期几啊"}
     * target_type : users
     */
    private List<String> target;
    private String from;
    private MsgEntity msg;
    private String target_type;

    public void setTarget(List<String> target) {
        this.target = target;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setMsg(MsgEntity msg) {
        this.msg = msg;
    }

    public void setTarget_type(String target_type) {
        this.target_type = target_type;
    }

    public List<String> getTarget() {
        return target;
    }

    public String getFrom() {
        return from;
    }

    public MsgEntity getMsg() {
        return msg;
    }

    public String getTarget_type() {
        return target_type;
    }

    public class MsgEntity {
        /**
         * type : txt
         * msg : 今天是星期几啊
         */
        private String type;
        private String msg;

        public void setType(String type) {
            this.type = type;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getType() {
            return type;
        }

        public String getMsg() {
            return msg;
        }
    }
}

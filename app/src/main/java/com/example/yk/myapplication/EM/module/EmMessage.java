package com.example.yk.myapplication.EM.module;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yk on 15/7/6.
 */
public class EmMessage {

    /**
     * groupChatId :
     * fromUser : lixuanwu
     * messageType : txt
     * msg : 今天是星期几啊
     * ext :
     * fileUrl :
     * id : 1
     * new : false
     * toUsers : []
     * isReplied : false
     * chatName :
     * doctorFlag : true
     * lastModifiedDate : 1436155011000
     * createdDate : 1436155011000
     * targetType : users
     */
    private String groupChatId;
    private String fromUser;
    private String messageType;
    private String msg;
    private String ext;
    private String fileUrl;
    private int id;
    @SerializedName("new")
    private boolean newX;
    private List<?> toUsers;
    private boolean isReplied;
    private String chatName;
    private boolean doctorFlag;
    private long lastModifiedDate;
    private long createdDate;
    private String targetType;

    public void setGroupChatId(String groupChatId) {
        this.groupChatId = groupChatId;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNewX(boolean newX) {
        this.newX = newX;
    }

    public void setToUsers(List<?> toUsers) {
        this.toUsers = toUsers;
    }

    public void setIsReplied(boolean isReplied) {
        this.isReplied = isReplied;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public void setDoctorFlag(boolean doctorFlag) {
        this.doctorFlag = doctorFlag;
    }

    public void setLastModifiedDate(long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getGroupChatId() {
        return groupChatId;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getMsg() {
        return msg;
    }

    public String getExt() {
        return ext;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public int getId() {
        return id;
    }

    public boolean isNewX() {
        return newX;
    }

    public List<?> getToUsers() {
        return toUsers;
    }

    public boolean isIsReplied() {
        return isReplied;
    }

    public String getChatName() {
        return chatName;
    }

    public boolean isDoctorFlag() {
        return doctorFlag;
    }

    public long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public String getTargetType() {
        return targetType;
    }
}

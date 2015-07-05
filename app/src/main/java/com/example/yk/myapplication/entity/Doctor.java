package com.example.yk.myapplication.entity;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by yk on 15/7/5.
 */
public class Doctor {

    @Expose
    private int id;

    /**
     * 手机
     */
    @Expose
    private String tel ;

    /**
     * 昵称
     */
    @Expose
    private String nickName ;

    /**
     * 头像地址
     */
    @Expose
    private String iconUrl ;

    /**
     * 性别
     */
    @Expose
    private String sex;



    /**
     * 身高
     */
    private double height;

    /**
     * 体重
     */
    @Expose
    private double weight;

    /**
     * 年龄
     */
    @Expose
    private int age;

    @Expose
    private Date birthday;

    @Expose
    private Date createdDate;

    @Expose
    private Date lastModifiedDate;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}

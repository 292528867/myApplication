package com.example.yk.myapplication;

/**
 * Created by yk on 15/6/11.
 */
public class MainEntry {
    private String title;

    private Class   name;

    public MainEntry(String title, Class name) {
        this.title = title;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getName() {
        return name;
    }

    public void setName(Class name) {
        this.name = name;
    }
}

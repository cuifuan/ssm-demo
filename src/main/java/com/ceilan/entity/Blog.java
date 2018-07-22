package com.ceilan.entity;

import java.math.BigInteger;

public class Blog {
    private Integer id;

    private String title;

    private String time;

    private byte[] content;

    private String contentblob;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentblob() {
        return contentblob;
    }

    public void setContentblob(String contentblob) {
        this.contentblob = contentblob;
    }
}
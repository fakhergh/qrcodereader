package com.benboubaker.qrcodereader.models;

/**
 * Created by fekhe on 07/11/2017.
 */

public class Code {

    private int id;
    private String content;
    private String type;

    public Code() {}

    public Code(int id, String content, String type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public Code setId(int id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Code setContent(String content) {
        this.content = content;
        return this;
    }

    public String getType() {
        return type;
    }

    public Code setType(String type) {
        this.type = type;
        return this;
    }
}

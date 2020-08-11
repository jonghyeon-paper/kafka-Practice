package com.example.demo.model;

public class DemoStructure {

    private Integer id;
    private String data;
    private String extraData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    @Override
    public String toString() {
        return "Demo [id=" + id + ", data=" + data + ", extraData=" + extraData + "]";
    }
}

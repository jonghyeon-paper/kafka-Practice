package com.example.demo2;

public class DemoStructure {

    private Integer id;
    private String data;
    private String extraData;

    public DemoStructure() {
    }

    public DemoStructure(Integer id, String data, String extraData) {
        super();
        this.id = id;
        this.data = data;
        this.extraData = extraData;
    }

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
        return "DemoStructure [id=" + id + ", data=" + data + ", extraData=" + extraData + "]";
    }
}

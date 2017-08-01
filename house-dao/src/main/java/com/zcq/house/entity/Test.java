package com.zcq.house.entity;

public class Test {
    private String id;

    private Integer name;

    public Test(String id, Integer name) {
        this.id = id;
        this.name = name;
    }

    public Test() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }
}
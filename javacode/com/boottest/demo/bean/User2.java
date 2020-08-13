package com.boottest.demo.bean;

public class User2 {
    private Integer id;

    private String name;

    public User2(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User2() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
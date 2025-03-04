package com.codecool.backend.dao.model;

public class User {
    private int id;
    private String name;

    public User(String name){
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

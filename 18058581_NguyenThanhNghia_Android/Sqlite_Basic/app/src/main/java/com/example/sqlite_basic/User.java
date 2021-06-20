package com.example.sqlite_basic;

public class User {
    private int id;
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

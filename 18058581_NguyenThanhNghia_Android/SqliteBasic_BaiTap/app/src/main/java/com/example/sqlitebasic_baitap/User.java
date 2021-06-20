package com.example.sqlitebasic_baitap;

public class User {
    private int id;
    private String name;

    private int imgNote;
    private int imgCancel;

    public User(String name, int imgNote, int imgCancel) {
        this.name = name;
        this.imgNote = imgNote;
        this.imgCancel = imgCancel;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getImgNote() {
        return imgNote;
    }

    public void setImgNote(int imgNote) {
        this.imgNote = imgNote;
    }

    public int getImgCancel() {
        return imgCancel;
    }

    public void setImgCancel(int imgCancel) {
        this.imgCancel = imgCancel;
    }

    public int getId() {
        return id;
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

    public User(String name) {
        this.name = name;
    }

    public User() {
    }


    public User(int id, String name, int imgNote, int imgCancel) {
        this.id = id;
        this.name = name;
        this.imgNote = imgNote;
        this.imgCancel = imgCancel;
    }
}

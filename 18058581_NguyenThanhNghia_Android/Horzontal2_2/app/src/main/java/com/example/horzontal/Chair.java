package com.example.horzontal;

public class Chair {
    private String title;
    private String money;
    private String description;
    private int imageChair;

    public Chair()
    {

    }
    public Chair(String title, String money, String description, int imageChair) {
        this.title = title;
        this.money = money;
        this.description = description;
        this.imageChair = imageChair;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageChair() {
        return imageChair;
    }

    public void setImageChair(int imageChair) {
        this.imageChair = imageChair;
    }
}

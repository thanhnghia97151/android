package com.example.gridview;

public class ElectricThing {
    private String name;
    private int rate;
    private int price;
    private int imgThing;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImgThing() {
        return imgThing;
    }

    public void setImgThing(int imgThing) {
        this.imgThing = imgThing;
    }

    public ElectricThing(String name, int rate, int price, int imgThing) {
        this.name = name;
        this.rate = rate;
        this.price = price;
        this.imgThing = imgThing;
    }
}

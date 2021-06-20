package com.example.recycleview;

public class ElectricThing {
    private String name;
    private String price;
    private int imgThing;
    private int rate;
    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImgThing() {
        return imgThing;
    }

    public void setImgThing(int imgThing) {
        this.imgThing = imgThing;
    }


    public ElectricThing(String name, String price, int imgThing,int rate) {
        this.name = name;
        this.price = price;

        this.imgThing = imgThing;
        this.rate=rate;
    }

}

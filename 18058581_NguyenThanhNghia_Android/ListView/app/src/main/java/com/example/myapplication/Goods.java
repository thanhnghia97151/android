package com.example.myapplication;

public class Goods {
    private String name;
    private String nameShop;
    private int imgGoods;

    public Goods(String name, String nameShop, int imgGoods) {
        this.name = name;
        this.nameShop = nameShop;
        this.imgGoods = imgGoods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public int getImgGoods() {
        return imgGoods;
    }

    public void setImgGoods(int imgGoods) {
        this.imgGoods = imgGoods;
    }
}

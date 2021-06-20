package com.example.a18043151_phanvanthong_android_tuan8_bai2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "diachi")
public class DiaChi implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private  int id;
    private String city;

    public DiaChi(int id, String city) {
        this.id = id;
        this.city = city;
    }

    public DiaChi(String city) {
        this.city = city;
    }

    public DiaChi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "DiaChi{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}

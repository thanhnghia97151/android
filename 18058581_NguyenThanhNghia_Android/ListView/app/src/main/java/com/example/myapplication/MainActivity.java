package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvGoods; //list view
    CustomGoodsAdapter adt;
    ArrayList<Goods> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvGoods =findViewById(R.id.lvGoods);
        arrayList =new ArrayList<>();
        arrayList.add(new Goods("Cáp 1","Shop1 ",R.drawable.carbusbtops2_1));
        arrayList.add(new Goods("Cáp 2","Shop1 ",R.drawable.daucam_1));
        arrayList.add(new Goods("Cáp 3","Shop2 ",R.drawable.dauchuyendoi_1));
        arrayList.add(new Goods("Cáp 4","Shop2 ",R.drawable.daynguon_1));
        arrayList.add(new Goods("Cáp 5","Shop2 ",R.drawable.giacchuyen_1));
        adt = new CustomGoodsAdapter(this,R.layout.item_listview,arrayList);
        lvGoods.setAdapter(adt);

    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/
}
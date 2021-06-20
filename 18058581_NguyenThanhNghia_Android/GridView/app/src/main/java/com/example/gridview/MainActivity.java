package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvThing;
    ArrayList<ElectricThing> arrayList;
    CustomAdapter adt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvThing=findViewById(R.id.gvThing);
        arrayList =new ArrayList<>();
        arrayList.add(new ElectricThing("day nguon",3,15000,R.drawable.daynguon_1));
        arrayList.add(new ElectricThing("day nguon",3,15000,R.drawable.daynguon_1));
        arrayList.add(new ElectricThing("day nguon",3,15000,R.drawable.daynguon_1));
        arrayList.add(new ElectricThing("day nguon",3,15000,R.drawable.daynguon_1));
        arrayList.add(new ElectricThing("day nguon",3,15000,R.drawable.daynguon_1));
        arrayList.add(new ElectricThing("day nguon",3,15000,R.drawable.daynguon_1));
        arrayList.add(new ElectricThing("day nguon",3,15000,R.drawable.daynguon_1));
        arrayList.add(new ElectricThing("day nguon",3,15000,R.drawable.daynguon_1));
        arrayList.add(new ElectricThing("day nguon",3,15000,R.drawable.daynguon_1));
        arrayList.add(new ElectricThing("day nguon",3,15000,R.drawable.daynguon_1));
        adt = new CustomAdapter(MainActivity.this,R.layout.item_gridview,arrayList);
        gvThing.setAdapter(adt);
    }
}
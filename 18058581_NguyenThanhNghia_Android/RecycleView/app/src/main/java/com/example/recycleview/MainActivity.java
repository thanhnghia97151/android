package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcvThing;
    private ElectricThingAdapter electricThingAdapter;
    private ArrayList<ElectricThing> electricThings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvThing = findViewById(R.id.rcvThing);
        electricThings = new ArrayList<>();
        electricThings.add(new ElectricThing("Day nguon","10000 ",R.drawable.daynguon_1,3));
        electricThings.add(new ElectricThing("Day nguon","10000 ",R.drawable.daynguon_1,3));
        electricThings.add(new ElectricThing("Day nguon","10000 ",R.drawable.daynguon_1,3));
        electricThings.add(new ElectricThing("Day nguon","10000 ",R.drawable.daynguon_1,3));
        electricThings.add(new ElectricThing("Day nguon","10000 ",R.drawable.daynguon_1,3));
        electricThings.add(new ElectricThing("Day nguon","10000 ",R.drawable.daynguon_1,3));
        electricThings.add(new ElectricThing("Day nguon","10000 ",R.drawable.daynguon_1,3));
        electricThings.add(new ElectricThing("Day nguon","10000 ",R.drawable.daynguon_1,3));
        electricThingAdapter = new ElectricThingAdapter(this,electricThings);
        rcvThing.setAdapter(electricThingAdapter);
        rcvThing.setLayoutManager(new LinearLayoutManager((this))); // SHow normal

        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2); // Show vs 2 cot
        rcvThing.setLayoutManager(gridLayoutManager);*/


       /* LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rcvThing.setLayoutManager(linearLayoutManager); // Show theo hang ngang*/

    }
}
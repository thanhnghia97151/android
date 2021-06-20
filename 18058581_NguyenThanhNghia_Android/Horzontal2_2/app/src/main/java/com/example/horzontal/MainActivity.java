package com.example.horzontal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Chair> chairList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chairList = new ArrayList<>();
        chairList.add(new Chair("category chair 1", "250", "this is information important about chair this is information important about chair this is information important about chair", R.drawable.chair1));
        chairList.add(new Chair("category chair 2", "150", "this is information important about chair this is information important about chair this is information important about chair", R.drawable.chair_2));
        chairList.add(new Chair("category chair 3", "350", "this is information important about chair this is information important about chair this is information important about chair", R.drawable.chair3));
        chairList.add(new Chair("category chair 4", "240", "this is information important about chair this is information important about chair this is information important about chair", R.drawable.chai4));
        recyclerView = findViewById(R.id.recyclerView);
        MyChairAdapter myChairAdapter = new MyChairAdapter(this, chairList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(myChairAdapter);
    }
}
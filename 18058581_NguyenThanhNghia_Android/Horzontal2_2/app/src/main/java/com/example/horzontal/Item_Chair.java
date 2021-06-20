package com.example.horzontal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Item_Chair extends AppCompatActivity {

    TextView txtDescription, txtTitleChair, txtMoneyChair;
    ImageView imageViewChair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__chair);
        txtDescription = findViewById(R.id.txtDescription);
        imageViewChair = findViewById(R.id.imageViewChair);
        txtTitleChair = findViewById(R.id.txtTitleChair);
        txtMoneyChair = findViewById(R.id.txtMoneyChair);
        Intent intent = getIntent();
        String des = intent.getExtras().getString("description");
        int image = intent.getExtras().getInt("image");
        String title = intent.getExtras().getString("title");
        String money = intent.getExtras().getString("money");
        txtDescription.setText(des);
        imageViewChair.setImageResource(image);
        txtTitleChair.setText(title);
        txtMoneyChair.setText("$"+money);
    }
}
package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomGoodsAdapter extends BaseAdapter {
    Context ctx;
    int layoutItem;
    ArrayList<Goods> arrayList;

    public CustomGoodsAdapter(Context ctx, int layoutItem, ArrayList<Goods> arrayList) {
        this.ctx = ctx;
        this.layoutItem = layoutItem;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(ctx).inflate(layoutItem,parent,false);
        TextView tvName=convertView.findViewById(R.id.tvName);
        TextView tvShopNmae=convertView.findViewById(R.id.tvShopName);
        ImageView imgGoods=convertView.findViewById(R.id.imgGoods);
        //
        tvName.setText(arrayList.get(position).getName());
        tvShopNmae.setText(arrayList.get(position).getNameShop());
        imgGoods.setImageResource(arrayList.get(position).getImgGoods());
        return convertView;
    }
}

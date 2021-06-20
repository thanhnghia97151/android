package com.example.thithudemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterListView extends BaseAdapter {
    Context ctx;
    int layoutItem;

    public CustomAdapterListView(Context ctx, int layoutItem, ArrayList<User> arrayList) {
        this.ctx = ctx;
        this.layoutItem = layoutItem;
        this.arrayList = arrayList;
    }

    ArrayList<User> arrayList;
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
        TextView tvid = convertView.findViewById(R.id.tvid);
        TextView tvname = convertView.findViewById(R.id.tvname);
        TextView tvage = convertView.findViewById(R.id.tvage);

        tvid.setText(arrayList.get(position).getId());
        tvname.setText(arrayList.get(position).getName());
        tvage.setText(arrayList.get(position).getAge());
        return convertView;
    }
}

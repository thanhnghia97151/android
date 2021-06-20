package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context ctx;
    private int layout;
    private ArrayList<ElectricThing> arrayList;

    public CustomAdapter(Context ctx, int layout, ArrayList<ElectricThing> arrayList) {
        this.ctx = ctx;
        this.layout = layout;
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
        ViewHolder viewHolder;
        if(convertView==null)
        {
            convertView = LayoutInflater.from(ctx).inflate(layout, parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvPrice = convertView.findViewById(R.id.tvPrice);
            viewHolder.rate= convertView.findViewById(R.id.rtbDanhGia);
            viewHolder.imgThing= convertView.findViewById(R.id.imgThing);
            convertView.setTag(viewHolder);
        } else {viewHolder = (ViewHolder)convertView.getTag();}
        //
        viewHolder.tvName.setText(arrayList.get(position).getName());
        viewHolder.tvPrice.setText(String.valueOf(arrayList.get(position).getPrice()));
        viewHolder.rate.setRating(arrayList.get(position).getRate());
        viewHolder.imgThing.setImageResource(arrayList.get(position).getImgThing());
        return convertView;
    }
    private  class ViewHolder{
        TextView tvName;
        TextView tvPrice;
        RatingBar rate;
        ImageView imgThing;
    }
}

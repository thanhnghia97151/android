package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ElectricThingAdapter extends RecyclerView.Adapter<ElectricThingAdapter.ThingViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<ElectricThing> electricThings;
    public ElectricThingAdapter(Context context, ArrayList<ElectricThing> electricThings) {
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
        this.electricThings = electricThings;
    }


    @NonNull
    @Override
    public ElectricThingAdapter.ThingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = layoutInflater.inflate(R.layout.item_electricthing,parent,false);
        return new ThingViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ElectricThingAdapter.ThingViewHolder holder, int position) {
        ElectricThing electricThing = electricThings.get(position);
        holder.tvName.setText(electricThing.getName());
        holder.tvPrice.setText(electricThing.getPrice());

        holder.imgThing.setImageResource(electricThing.getImgThing());
        holder.rtBar.setRating(electricThing.getRate());
    }

    @Override
    public int getItemCount() {
        return  electricThings.size();
    }

    public class ThingViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvPrice;
        ImageView imgThing;
        RatingBar rtBar;
        ElectricThingAdapter electricThingAdapter;
        public ThingViewHolder(@NonNull View itemView, ElectricThingAdapter adapter ) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            rtBar=itemView.findViewById(R.id.rtbDanhGia);
            imgThing=itemView.findViewById(R.id.imgThing);

            this.electricThingAdapter=adapter;
        }
    }
}

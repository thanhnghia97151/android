package com.example.fulldemothithu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context ctx;
    List<Users> list = new ArrayList<>();
    LayoutInflater layoutInflater;
    public CustomAdapter(Context ctx, List<Users> list) {
        this.ctx = ctx;
        this.list = list;
        layoutInflater = LayoutInflater.from(ctx);
    }



    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView=layoutInflater.inflate(R.layout.item_user,parent,false);
        return new ViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Users user = list.get(position);
        holder.tvid.setText(user.getId());
        holder.tvname.setText(user.getName());
        holder.tvage.setText(user.getAge());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvid,tvname,tvage;
        CustomAdapter adapter;
        public ViewHolder(@NonNull View itemView, CustomAdapter adt) {
            super(itemView);
            tvid = itemView.findViewById(R.id.tvid);
            tvname = itemView.findViewById(R.id.tvname);
            tvage = itemView.findViewById(R.id.tvage);

            this.adapter = adt;
        }
    }
}

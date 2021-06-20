package com.example.a18043151_phanvanthong_android_tuan8_bai2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    List<DiaChi> list = new ArrayList<>();
    LayoutInflater layoutInflater;
    OnDiaChiListener onDiaChiListener;
    interface OnDiaChiListener{
        void onDiaChiClick(int position);
    }

    public void setOnDiaChiListener(OnDiaChiListener onDiaChiListener) {
        this.onDiaChiListener = onDiaChiListener;
    }

    public AddressAdapter(Context context, List<DiaChi> list,OnDiaChiListener onDiaChiListener) {
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
        this.onDiaChiListener = onDiaChiListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.address_item,parent,false),onDiaChiListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.address.setText(new StringBuilder((position+1)+" . ").append(list.get(position).getCity()));
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectDB.getInstance(holder.btnRemove.getContext().getApplicationContext()).diaChiDAO().deleteDiaChi(list.get(position));
                MainActivity.recyclerView.setAdapter(MainActivity.adapter = new AddressAdapter(holder.btnRemove.getContext(),ConnectDB.getInstance(holder.btnRemove.getContext()).diaChiDAO().getAllDiaChi(),onDiaChiListener));
            }
        });
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.btnEdit.getContext(),EditDiaChiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("diachi",list.get(position));
                intent.putExtras(bundle);
                holder.btnEdit.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        OnDiaChiListener onDiaChiListener;
        ImageButton btnEdit;
        ImageButton btnRemove;
        public ViewHolder(@NonNull View itemView,OnDiaChiListener onDiaChiListener) {
            super(itemView);
            this.onDiaChiListener = onDiaChiListener;
            address = itemView.findViewById(R.id.address);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnRemove = itemView.findViewById(R.id.btnRemove);
        }
    }
}

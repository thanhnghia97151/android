package com.example.democuoiky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<User> list;

    public CustomAdapter(Context context, List<User> electricThings) {
        this.context = context;
        layoutInflater = layoutInflater.from(context);
        this.list = electricThings;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView=layoutInflater.inflate(R.layout.item_user,parent,false);
        return new ViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        User user = list.get(position);
        String stt = position+1+".";
        holder.txtname.setText(stt+" "+user.getName());
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectDB.getInstance(context).userDAO().deleteUser(list.get(position));
                MainShow.recyclerView.setAdapter(MainShow.adapter = new CustomAdapter(holder.btnRemove.getContext(),ConnectDB.getInstance(context).userDAO().getAllUser()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtname;
        ImageButton btnNote,btnRemove;
        CustomAdapter adt;
        public ViewHolder(@NonNull View itemView, CustomAdapter adapter) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtname);
            btnNote = itemView.findViewById(R.id.btnNote);
            btnRemove = itemView.findViewById(R.id.btnRemove);

            this.adt=adapter;
        }
    }
}

package com.example.horzontal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyChairAdapter extends RecyclerView.Adapter<MyChairAdapter.MyViewHolder> {
    List<Chair> chairList;
    Context context;
    public MyChairAdapter(Context context, List<Chair> chairList)
    {
        this.context=context;
        this.chairList = chairList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(R.layout.item_chair, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Chair chair = chairList.get(position);
        holder.imageView.setImageResource(chair.getImageChair());
        holder.txtTitle.setText(chair.getTitle());
        holder.txtMoney.setText(chair.getMoney());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, Item_Chair.class);
               intent.putExtra("image",chair.getImageChair());
                intent.putExtra("title",chair.getTitle());
                intent.putExtra("description",chair.getDescription());
                intent.putExtra("money",chair.getMoney());
               context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        if (chairList!=null)
        return chairList.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtMoney,txtTitle;
        ImageView imageView;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMoney= itemView.findViewById(R.id.txtMoney);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}

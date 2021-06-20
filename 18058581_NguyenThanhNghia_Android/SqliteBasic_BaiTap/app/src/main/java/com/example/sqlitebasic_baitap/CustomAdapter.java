package com.example.sqlitebasic_baitap;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context ctx;
    int layoutItem;
    ArrayList<User> arrayList;

    public CustomAdapter(Context ctx, int layoutItem, ArrayList<User> arrayList) {
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
        TextView txtName = convertView.findViewById(R.id.txtName);
        ImageView imgNote = convertView.findViewById(R.id.imgNote);
        ImageView imgCancel = convertView.findViewById(R.id.imgCancel);
        //
        txtName.setText(arrayList.get(position).getName());
        imgNote.setImageResource(arrayList.get(position).getImgNote());
        imgCancel.setImageResource(arrayList.get(position).getImgCancel());

        //Set sự kiện Romove
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int viTriCham = arrayList.get(position).getName().indexOf(".");
                String t = arrayList.get(position).getName().substring(0,viTriCham);
                int index =Integer.parseInt(t);
                //Mở database

                SQLiteDatabase db= null;
                try {
                    db= SQLiteDatabase.openOrCreateDatabase("/data/data/com.example.sqlitebasic_baitap/databases/userdb_baitap",null);
                }
                catch (SQLException ex)
                {
                    Log.e("Lỗi kết nối",ex.getMessage());
                }

                db.delete("user","id=?", new String[]{String.valueOf(index)});
                db.close();
                Intent intent = new Intent(ctx,MainActivity.class);
                ctx.startActivity(intent);
            }

        });
        return convertView;
    }
}

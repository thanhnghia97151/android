package com.example.tikifragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static java.lang.Integer.parseInt;

public class Fragment_Above extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View above=inflater.inflate(R.layout.fragment_above,container,false);
        ImageButton imgMinus = above.findViewById(R.id.imgMinus);
        ImageButton imgAdd = above.findViewById(R.id.imgAdd);
        TextView tvQuality = above.findViewById(R.id.tvQuality);
//Cong
        imgAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int dem=Integer.parseInt((String) tvQuality.getText());

                dem++;
                tvQuality.setText(String.valueOf(dem));
            }
        });
        //Tru
        imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dem=Integer.parseInt((String) tvQuality.getText());
                if (dem>1) dem--;
                tvQuality.setText(String.valueOf(dem));
            }
        });
        return above;
    }
}

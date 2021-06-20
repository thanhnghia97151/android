package com.example.horzontal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment_Blank extends Fragment {

    ImageView imageCong, imageTru;
    TextView txtNumber;
    int quality;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_fragment__blank, container , false);
        imageCong = view.findViewById(R.id.imageViewCong);
        imageTru = view.findViewById(R.id.imageViewTru);
        txtNumber = view.findViewById(R.id.txtNumber);
        quality = Integer.parseInt((String) txtNumber.getText());
        imageCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quality>=0)
                {
                    quality++;
                    txtNumber.setText(String.valueOf(quality));
                }
            }
        });

        imageTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quality >1)
                {
                    quality--;
                    txtNumber.setText(String.valueOf(quality));
                }
            }
        });
        return view;
    }
}
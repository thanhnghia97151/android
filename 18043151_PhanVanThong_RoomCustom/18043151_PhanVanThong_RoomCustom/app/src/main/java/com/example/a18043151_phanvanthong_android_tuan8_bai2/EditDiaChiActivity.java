package com.example.a18043151_phanvanthong_android_tuan8_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditDiaChiActivity extends AppCompatActivity {
    TextView id;
    Button btnEdit;
    EditText editCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dia_chi);
        id = findViewById(R.id.idDiaChi);
        btnEdit = findViewById(R.id.btnEditAddress);
        editCity = findViewById(R.id.tvEditDiaChi);
        Intent intent = getIntent();
        Bundle bundle=intent.getExtras();
        DiaChi diaChi = (DiaChi) bundle.getSerializable("diachi");
        id.setText(new StringBuilder("ID : ").append(diaChi.getId()));
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city  = editCity.getText().toString();
                DiaChi diaChiNew = new DiaChi(diaChi.getId(),city);
                ConnectDB.getInstance(EditDiaChiActivity.this).diaChiDAO().updateDiachi(diaChiNew);
                Intent intent = new Intent(EditDiaChiActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
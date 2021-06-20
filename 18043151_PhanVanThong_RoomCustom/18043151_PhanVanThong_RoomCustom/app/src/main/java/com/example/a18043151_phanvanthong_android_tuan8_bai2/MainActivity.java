package com.example.a18043151_phanvanthong_android_tuan8_bai2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static RecyclerView recyclerView;
    Button btnAdd;
    Button btnCancel;
    EditText editAddress;
    public static List<DiaChi> list = new ArrayList<>();
    AddressAdapter.OnDiaChiListener onDiaChiListener;
    public static AddressAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
//        list= ConnectDB.getInstance(MainActivity.this).addressDAO().getAllAddresses();
        list = ConnectDB.getInstance(MainActivity.this).diaChiDAO().getAllDiaChi();
         adapter = new AddressAdapter(MainActivity.this,list,onDiaChiListener);
         recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));
         recyclerView.setAdapter(adapter);
         btnAdd = findViewById(R.id.btnAdd);
         editAddress = findViewById(R.id.editTextTextMultiLine);
         btnAdd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String city = editAddress.getText().toString();
                 ConnectDB.getInstance(MainActivity.this).diaChiDAO().addDiaChi(new DiaChi(city));
                 list= ConnectDB.getInstance(MainActivity.this).diaChiDAO().getAllDiaChi();
                 adapter = new AddressAdapter(MainActivity.this,list,onDiaChiListener);
                 recyclerView.setAdapter(adapter);
                 editAddress.setText("");
                 InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                 inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
             }
         });
         adapter.setOnDiaChiListener(new AddressAdapter.OnDiaChiListener() {
             @Override
             public void onDiaChiClick(int position) {

             }
         });
         btnCancel = findViewById(R.id.btnCancel);
         btnCancel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 editAddress.setText("");
                 InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                 inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
             }
         });
    }
}
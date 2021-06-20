package com.example.sqlite_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    DataUser dataUser;
    Button btnAdd, btnRemove, btnCancel;
    EditText txtName;
    ListView lvName;
    ArrayList nameList;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataUser=new DataUser(this,"userdb",null,1);

        nameList = new ArrayList();

        btnAdd=findViewById(R.id.btnAdd);
        btnRemove=findViewById(R.id.btnRemove);
        btnCancel=findViewById(R.id.btnCancel);
        txtName = findViewById(R.id.txtName);
        lvName = findViewById(R.id.lvName);
        txtName = findViewById(R.id.txtName);
        nameList=getNameList();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,nameList);
        lvName.setAdapter(adapter);
    }
    private ArrayList getNameList()
    {
        ArrayList<String> namList= new ArrayList<>();
        for (Iterator iterator = dataUser.getAll().iterator(); iterator.hasNext(); ) {

            User user =(User) iterator.next();
            nameList.add(user.getName());
        }
        return nameList;
    }
}
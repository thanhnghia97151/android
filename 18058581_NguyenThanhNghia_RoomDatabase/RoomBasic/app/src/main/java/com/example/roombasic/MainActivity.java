package com.example.roombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<User> list = new ArrayList<>();
    UserAdapter adapter;
    Button bntAdd;
    EditText editPutName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcvname);
        bntAdd = findViewById(R.id.btnadd);
        editPutName = findViewById(R.id.edtname);
        //
        list = ConnectDB.getInstance(MainActivity.this).userDAO().getAllUser();
        adapter = new UserAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        //
        bntAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editPutName.getText().toString();
                ConnectDB.getInstance(MainActivity.this).userDAO().addUser(new User(name));
                list = ConnectDB.getInstance(MainActivity.this).userDAO().getAllUser();
                adapter = new UserAdapter(MainActivity.this,list);
                recyclerView.setAdapter(adapter);

            }
        });
    }
}
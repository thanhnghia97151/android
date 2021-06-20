package com.example.democuoiky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainShow extends AppCompatActivity {
    public static RecyclerView recyclerView;
    List<User> list = new ArrayList<>();
    Button bntAdd,btnPost;
    EditText editPutName;
    public static CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        recyclerView = findViewById(R.id.rcvUser);
        bntAdd = findViewById(R.id.btnAdd);
        btnPost = findViewById(R.id.btnPost);
        editPutName = findViewById(R.id.editTextname);
        //
        list = ConnectDB.getInstance(MainShow.this).userDAO().getAllUser();
        adapter = new CustomAdapter(MainShow.this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        //
        bntAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editPutName.getText().toString();
                ConnectDB.getInstance(MainShow.this).userDAO().addName(new User(name));
                list = ConnectDB.getInstance(MainShow.this).userDAO().getAllUser();
                adapter = new CustomAdapter(MainShow.this,list);
                recyclerView.setAdapter(adapter);
            }
        });
        //
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0;i<list.size();i++)
                {
                    PostApi("https://60cde62691cc8e00178dc177.mockapi.io/User",list.get(i).getName());
                }


            }
        });
    }
    private void PostApi(String url, String ten){
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(MainShow.this, "Successfully", Toast.LENGTH_SHORT).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainShow.this, "Error by Post data!", Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String>
                        params = new HashMap<>();
                params.put("name", ten);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

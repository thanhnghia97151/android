package com.example.fulldemothithu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainUser extends AppCompatActivity {
    RecyclerView recyclerUser;
    ArrayList arrayList;
    Button btnpost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        btnpost = findViewById(R.id.btnpost);
        recyclerUser = findViewById(R.id.rcvuser);
        arrayList = new ArrayList();
        GetArrayJson("https://60ad917480a61f00173312ce.mockapi.io/user",arrayList,recyclerUser);

        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostApi("https://60ad917480a61f00173312ce.mockapi.io/user",arrayList,recyclerUser);
            }
        });

    }



    private void GetArrayJson(String url, ArrayList arr, RecyclerView rcv){
        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(url,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                for(int i=0; i<response.length(); i++){
                                    try {
                                        JSONObject object = (JSONObject) response.get(i);
                                        arr.add(new Users("ID: "+object.getString("id").toString(),"Name: "+object.getString("name").toString(),"Age: "+object.getString("age").toString()));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                rcv.clearFocus();
                                CustomAdapter adt = new CustomAdapter(MainUser.this,arr);
                                rcv.setLayoutManager(new GridLayoutManager(MainUser.this,1));
                                rcv.setAdapter(adt);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainUser.this, "Error by get Json Array!", Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    private void PostApi(String url,ArrayList arr, RecyclerView rcv){
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GetArrayJson("https://60ad917480a61f00173312ce.mockapi.io/user",arr,rcv);
                        Toast.makeText(MainUser.this, "Successfully", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainUser.this, "Error by Post data!", Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String, String>
                        params = new HashMap<>();
                params.put("name", "Lâm");
                params.put("age", "40");

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

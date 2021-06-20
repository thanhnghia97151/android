package com.example.thithudemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class ItemUser extends AppCompatActivity {
    EditText edit_id,edit_name,edit_age;
    Button btn_xem;
    ListView listView;
    String url="https://60ad917480a61f00173312ce.mockapi.io/user/3";
    ArrayList<User> arrayList = new ArrayList<>();
    CustomAdapterListView adt;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_user);
        edit_id = findViewById(R.id.edit_id);
        edit_name = findViewById(R.id.edit_name);
        edit_age = findViewById(R.id.edit_age);

        btn_xem = findViewById(R.id.btn_xem);

        listView = findViewById(R.id.lv_user);

        GetArrayJson("https://60ad917480a61f00173312ce.mockapi.io/user",listView);


        //event
        btn_xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData(url);
            }
        });
    }

    private void GetArrayJson(String url,ListView listView){

        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(url,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                ArrayList<String> arr = new ArrayList<>();
                                for(int i=0; i<response.length(); i++){
                                    try {
                                        JSONObject object = (JSONObject) response.get(i);
                                        arr.add("Id: "+object.getString("id").toString()+"    Name: "+object.getString("name").toString()+"    Age: "+object.getString("age").toString());
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                listView.clearFocus();
                                ArrayAdapter adapter = new ArrayAdapter(ItemUser.this, android.R.layout.simple_list_item_1,arr);
                                listView.setAdapter(adapter);
                                Toast.makeText(ItemUser.this, "True", Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ItemUser.this, "Error by get Json Array!", Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);


    }

    private void GetData(String url) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            edit_id.setText(response.getString("id").toString());
                            edit_name.setText(
                                    response.getString("name").toString());
                            edit_age.setText(response.getString("age").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ItemUser.this, "Error by get JsonObject...", Toast.LENGTH_SHORT).show();
            }
        }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}

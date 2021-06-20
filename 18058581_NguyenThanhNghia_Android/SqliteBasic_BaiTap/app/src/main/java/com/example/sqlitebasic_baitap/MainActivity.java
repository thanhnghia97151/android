package com.example.sqlitebasic_baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    public DataUser dataUser;
    ListView lvName;
    ArrayList nameList;
    ArrayList idList;
    ArrayAdapter adapter;
    CustomAdapter adt;
    ArrayList<User> list;

    Button btnSave;
    Button btnCancel;
    EditText content;
    ImageButton imgNote;
    ImageButton imgCancel;

    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvName = findViewById(R.id.lv);
        dataUser=new DataUser(this,"userdb_baitap",null,1);
        /*dataUser.AddUser(new User("Đà Lạt"));
        dataUser.AddUser(new User("Buôn Mê Thuộc"));
        dataUser.AddUser(new User("Cần Thơ"));
        dataUser.AddUser(new User("Phú Quốc"));
        dataUser.AddUser(new User("Lý Sơn"));
        dataUser.AddUser(new User("Côn Đảo"));
        dataUser.AddUser(new User("Vũng Tàu"));
        dataUser.AddUser(new User("Nha Trang"));*/
        lvName = findViewById(R.id.lv);
        //nameList = new ArrayList();
        //nameList=getNameList();
        //adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,nameList);
        //lvName.setAdapter(adapter);
        idList = new ArrayList();
        idList = getIDList();
        list = new ArrayList<>();
        list=getList();
        adt = new CustomAdapter(this, R.layout.item_danhsach,list);
        lvName.setAdapter(adt);

        //Nút Save
        content = findViewById(R.id.editTextPlace);
        btnSave= findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = content.getText().toString();
                dataUser.AddUser(new User(t));
                list.add(new User(lvName.getCount()+1+". "+t,R.drawable.vector__1_,R.drawable.vector__3_));
                lvName.setAdapter(adt);
            }
        });
        //Nút Cancel
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
    private ArrayList getIDList()
    {
        ArrayList idList = new ArrayList();
        for (Iterator iterator = dataUser.getAll().iterator(); iterator.hasNext(); ) {

            User user =(User) iterator.next();
            idList.add(user.getId());
        }
        return idList;
    }
    private ArrayList<User> getList( )
    {
        idList = new ArrayList();
        list = new ArrayList<>();
        for (Iterator iterator = dataUser.getAll().iterator(); iterator.hasNext(); ) {
            User user =(User) iterator.next();
            String t = user.getId()+". "+user.getName();
            list.add(new User(t,R.drawable.vector__1_,R.drawable.vector__3_));
        }
        return list;
    }
}
package com.example.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.assignment1.Models.ListItem;
import com.example.assignment1.adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton floatingActionButton;
    Activity activity;
    Intent intent;
    DatabaseHandler db = new DatabaseHandler(this);
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> itemList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //ListItem facebook=new ListItem("FACEBOOK","to surfffff");
        //ListItem google=new ListItem("GOOGLE","to gooogleeee");
        //ListItem twitter=new ListItem("TWITTER","to tweeeeet");
        //itemList.add(facebook);
        //itemList.add(google);
        //for(int i=0;i<10;i++){
        //itemList.add(twitter);}
        adapter = new RecyclerViewAdapter(this, itemList);

        recyclerView.setAdapter(adapter);


        activity = this;
        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);

        intent = new Intent(activity, AddItemActivity.class);


        Cursor cursor = db.getMyItem();
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                itemList.add(new ListItem(cursor.getString(1), cursor.getString(2)));
            }
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            assert data != null;
            Bundle Extras = data.getExtras();
            assert Extras != null;
            itemList.add(new ListItem(Extras.getString("name"), Extras.getString("desc")));
            db.addListItem(new ListItem(Extras.getString("name"), Extras.getString("desc")));

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Toast.makeText(activity, "going to add item", Toast.LENGTH_SHORT).show();

                startActivityForResult(intent, 0);

        }
    }
}

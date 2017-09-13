package com.example.codetride.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    Intent intent;
    Content content;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        listView = (ListView) findViewById(R.id.top_view);

        final ArrayList<Content> contents = new ArrayList<>();

        contents.add(new Content("Doubletree Hotel","#1","Cape Town",R.drawable.double_tree_hotel,R.string.hilton));
        contents.add(new Content("Protea Hotel","#2","Cape Town",R.drawable.protea_hotel,R.string.Protea));
        contents.add(new Content("President Hotel","#3","Port Elizabeth",R.drawable.president_hotel,R.string.president));
        contents.add(new Content("Radisson Blu Hotel","#4","Port Elizabeth",R.drawable.radisson_blu_hotel,R.string.blu));
        contents.add(new Content("Bay Hotel","#5","Port Elizabeth",R.drawable.bay_hotel,R.string.bay));

        TopAdapter topAdapter = new TopAdapter(this,contents);

        listView.setAdapter(topAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Content content = contents.get(i);

                intent = new Intent(HotelsActivity.this,Display3.class);
                intent.putExtra("Hotel",content);
                startActivity(intent);
            }
        });
    }
}

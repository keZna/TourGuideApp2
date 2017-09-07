package com.example.codetride.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PopularActivity extends AppCompatActivity {

    Intent intent;
    Content content;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        listView = (ListView) findViewById(R.id.top_view);

        final ArrayList<Content> contents = new ArrayList<>();
        contents.add(new Content("Cape Town Central","#1","Cape Town",R.drawable.cape_town_central,R.string.cape));
        contents.add(new Content("Johannesburg","#2","Johannesburg",R.drawable.johannesburg,R.string.johannesburg));
        contents.add(new Content("Durban","#3","Durban",R.drawable.durban,R.string.durban));
        contents.add(new Content("Pretoria","#4","Pretoria",R.drawable.pretoria,R.string.pretoria));

        TopAdapter topAdapter = new TopAdapter(this,contents);

        listView.setAdapter(topAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Content content = contents.get(i);

                intent = new Intent(PopularActivity.this,Display.class);
                intent.putExtra("Popular",content);
                startActivity(intent);
            }
        });
    }
}

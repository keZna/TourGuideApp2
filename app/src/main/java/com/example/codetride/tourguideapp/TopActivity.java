package com.example.codetride.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TopActivity extends AppCompatActivity {

    Intent intent;
    Content content;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        listView = (ListView) findViewById(R.id.top_view);

        final ArrayList<Content> contents = new ArrayList<>();

        contents.add(new Content("Eiffel Towel","#1","Found in Paris",R.drawable.eiffel,R.string.eiffel));
        contents.add(new Content("Louvre Museum","#2","Found in Germany",R.drawable.louvre,R.string.louvre));

        TopAdapter topAdapter = new TopAdapter(this,contents);

        listView.setAdapter(topAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Content content = contents.get(i);

                intent = new Intent(TopActivity.this,Display2.class);
                intent.putExtra("Top",content);
                startActivity(intent);
            }
        });
    }
}

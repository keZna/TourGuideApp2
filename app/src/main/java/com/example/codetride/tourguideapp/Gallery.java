package com.example.codetride.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    GridView gridView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gridView = (GridView) findViewById(R.id.gallery);

        final ArrayList<Content> contents = new ArrayList<>();

        //20 pics that are set in the gallery views
        contents.add(new Content(R.drawable.king,"Lion"));
        contents.add(new Content(R.drawable.eagles,"Eagles"));
        contents.add(new Content(R.drawable.elphent,"Elephant"));
        contents.add(new Content(R.drawable.fish,"Under water"));
        contents.add(new Content(R.drawable.giraffe,"Giraffe"));
        contents.add(new Content(R.drawable.rhino,"Rhinos"));
        contents.add(new Content(R.drawable.johannesburg,"Johannesburg"));
        contents.add(new Content(R.drawable.gff,"Giraffe"));
        contents.add(new Content(R.drawable.mountains,"Mountains"));
        contents.add(new Content(R.drawable.durban,"Durban"));
        contents.add(new Content(R.drawable.pretoria,"Pretoria"));
        contents.add(new Content(R.drawable.zebra,"Zebra"));
        contents.add(new Content(R.drawable.rainbow,"Rainbow"));
        contents.add(new Content(R.drawable.village,"Village"));
        contents.add(new Content(R.drawable.stellenbosch,"Stellenbosch"));
        contents.add(new Content(R.drawable.rhinos,"Rhino"));
        contents.add(new Content(R.drawable.male_e,"Elephant"));

        GalleryAdapter contentAdapter = new GalleryAdapter(this, contents);
        gridView.setAdapter(contentAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Content content = contents.get(i);

                intent = new Intent(Gallery.this,Gallery1.class);
                intent.putExtra("Gallery",content);
                startActivity(intent);
            }
        });
    }
}

package com.example.codetride.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Gallery1 extends AppCompatActivity {

    ImageView imageView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery1);

        imageView = (ImageView) findViewById(R.id.gallery1);

        intent = getIntent();

        Content content = (Content) intent.getSerializableExtra("Gallery");
        imageView.setImageResource(content.getmImageResourceId());
    }
}

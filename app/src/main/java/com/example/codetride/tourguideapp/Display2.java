package com.example.codetride.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class Display2 extends AppCompatActivity {

    TextView name, desc, full, number;
    ImageView imageView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();
        name = (TextView) findViewById(R.id.display_name);
        imageView = (ImageView) findViewById(R.id.display_image);
        desc = (TextView) findViewById(R.id.display_desc);
        number = (TextView) findViewById(R.id.display_number);
        full = (TextView) findViewById(R.id.display_full);

        Content content = (Content) intent.getSerializableExtra("Top");

        name.setText(content.getName());
        imageView.setImageResource(content.getmImageResourceId());
        desc.setText(content.getShortDesc());
        number.setText(content.getmNumber());
        full.setText(content.getmFull());

    }
}

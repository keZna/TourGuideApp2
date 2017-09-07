package com.example.codetride.tourguideapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTride on 2017/08/18.
 */

public class DisplayAdapter extends ArrayAdapter<Content> {
    public DisplayAdapter(Context context, ArrayList<Content> contents) {
        super(context, 0, contents);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Content currentContent = getItem(position);

        View itemDisplay = convertView;

        if (itemDisplay==null){
            itemDisplay = LayoutInflater.from(getContext()).inflate(R.layout.popular,parent,false);
        }

        TextView name, desc, full, number;
        ImageView imageView;

        name = itemDisplay.findViewById(R.id.display_name);
        name.setText(currentContent.getName());
        desc = itemDisplay.findViewById(R.id.display_desc);
        desc.setText(currentContent.getShortDesc());
        full = itemDisplay.findViewById(R.id.display_full);
        full.setText(currentContent.getmFull());
        number = itemDisplay.findViewById(R.id.display_number);
        number.setText(currentContent.getmNumber());
        imageView = itemDisplay.findViewById(R.id.display_image);
        imageView.setImageResource(currentContent.getmImageResourceId());


        return itemDisplay;

    }
}

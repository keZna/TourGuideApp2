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

public class TopAdapter extends ArrayAdapter<Content> {


    public TopAdapter(Context context, ArrayList<Content> contents) {
        super(context, 0, contents);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Content currentContent = getItem(position);

        View itemTop = convertView;

        if (itemTop==null){
            itemTop = LayoutInflater.from(getContext()).inflate(R.layout.top_places,parent,false);
        }

        TextView top_number, top_place, top_desc, full;
        ImageView top_image;

        top_place = itemTop.findViewById(R.id.top_name);
        top_place.setText(currentContent.getName());

        top_desc = itemTop.findViewById(R.id.top_desc);
        top_desc.setText(currentContent.getShortDesc());

        top_number = itemTop.findViewById(R.id.top_number);
        top_number.setText(currentContent.getmNumber());

        full = itemTop.findViewById(R.id.top_full);
        if (currentContent.hasFull()){
            full.setVisibility(View.VISIBLE);
        }else {
            full.setVisibility(View.GONE);
        }

        top_image = itemTop.findViewById(R.id.top_image);
        top_image.setImageResource(currentContent.getmImageResourceId());

        return itemTop;
    }
}

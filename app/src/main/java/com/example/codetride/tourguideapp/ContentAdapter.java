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
 * Created by CodeTride on 2017/08/16.
 */

public class ContentAdapter extends ArrayAdapter<Content> {
    public ContentAdapter(Context context, ArrayList<Content> contents) {
        super(context, 0, contents);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Content currentContent = getItem(position);
        View itemView = convertView;
        if (itemView==null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.main_list,parent,false);
        }

        TextView name, shortDesc,place;
        ImageView imageView;

        name = itemView.findViewById(R.id.name);
        name.setText(currentContent.getName());

        shortDesc = itemView.findViewById(R.id.shortDesc);
        if (currentContent.hasDescs()){
            shortDesc.setText(currentContent.getShortDesc());
            shortDesc.setVisibility(View.VISIBLE);
        }else {
            shortDesc.setVisibility(View.GONE);
        }

        place = itemView.findViewById(R.id.place);
        if (currentContent.hasDescs()){
            place.setText(currentContent.getPlace());
            place.setVisibility(View.VISIBLE);
        }else {
            place.setVisibility(View.GONE);
        }

        imageView = itemView.findViewById(R.id.image);
        if (currentContent.hasImage()){
            imageView.setImageResource(currentContent.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }

        return itemView;
    }
}

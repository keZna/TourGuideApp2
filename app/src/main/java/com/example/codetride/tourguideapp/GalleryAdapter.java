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
 * Created by CodeTride on 2017/08/17.
 */

public class GalleryAdapter extends ArrayAdapter<Content> {
    public GalleryAdapter(Context context, ArrayList<Content> contents) {
        super(context, 0, contents);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Content currentContent = getItem(position);
        View itemView = convertView;
        if (itemView==null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.gallery,parent,false);
        }

        ImageView imageView;
        TextView namePlace;

        imageView = itemView.findViewById(R.id.image_Gallery);
        if (currentContent.hasImage()){
            imageView.setImageResource(currentContent.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }

        namePlace= itemView.findViewById(R.id.namePlace);
        namePlace.setText(currentContent.getPlace());

        return itemView;
    }
}

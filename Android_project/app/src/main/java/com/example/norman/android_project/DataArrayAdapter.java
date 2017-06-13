package com.example.norman.android_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class DataArrayAdapter  extends ArrayAdapter<Data> {
    Context context;
    public DataArrayAdapter (Context context, List<Data> items) {
        super(context, 0, items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout itemlayout = null;
        if (convertView == null) {
            itemlayout = (LinearLayout) inflater.inflate(R.layout.data_item, null);
        } else {
            itemlayout = (LinearLayout) convertView;
        }
        Data item = (Data) getItem(position);
        TextView textView12 = (TextView) itemlayout.findViewById(R.id.textView12);
        textView12.setText(item.getClassification());
        TextView textView = (TextView) itemlayout.findViewById(R.id.textView);
        textView.setText(item.getTitle());

        /*
        ImageView ivPet = (ImageView) itemlayout.findViewById(R.id.iv_pet);
        ivPet.setImageBitmap(item.getImgUrl());
        */
        return itemlayout;
    }
}
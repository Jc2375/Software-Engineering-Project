package com.example.vam1994.speedbytedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by vam1994 on 3/26/17.
 */
public class CustomAdapterReservationTiming extends ArrayAdapter<String>{

    /**
     * Instantiates a new Custom adapter reservation timing.
     *
     * @param context  the context
     * @param resource the resource
     */
    public CustomAdapterReservationTiming(Context context, String[] resource) {
        super(context, R.layout.reservationtimerows, resource);
    }

    /**
     * Set a custom view
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater LI = LayoutInflater.from(getContext());
        View customView = LI.inflate(R.layout.reservationtimerows, parent, false);

        String time = getItem(position);
        TextView tv = (TextView)customView.findViewById(R.id.time);
        CheckBox cb = (CheckBox)customView.findViewById(R.id.checkbox);

        tv.setText(time);

        return customView;

    }


}

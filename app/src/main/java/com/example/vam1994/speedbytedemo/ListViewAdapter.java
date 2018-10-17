package com.example.vam1994.speedbytedemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vam1994 on 3/27/17.
 */
public class ListViewAdapter extends ArrayAdapter<FoodItem> {

    private AppCompatActivity activity;
    private List<FoodItem> foodItemList;

    /**
     * Instantiates a new List view adapter.
     *
     * @param context  the context
     * @param resource the resource
     * @param objects  the objects
     */
    public ListViewAdapter(AppCompatActivity context, int resource, List<FoodItem> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.foodItemList = objects;
    }

    /**
     * Overrides the getItem of FoodItem class
     * @param position
     * @return
     */
    @Override
    public FoodItem getItem(int position) {
        return foodItemList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
            //holder.ratingBar.getTag(position);
        }

        holder.ratingBar.setOnRatingBarChangeListener(onRatingChangedListener(holder, position));

        holder.ratingBar.setTag(position);
        holder.ratingBar.setRating(getItem(position).getRating());
        holder.movieName.setText(getItem(position).getName());

        return convertView;
    }

    private RatingBar.OnRatingBarChangeListener onRatingChangedListener(final ViewHolder holder, final int position) {
        return new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                FoodItem item = getItem(position);
                item.setRating(v);
                Log.i("Adapter", "star: " + v);
            }
        };
    }

    private static class ViewHolder {
        private RatingBar ratingBar;
        private TextView movieName;

        /**
         * Instantiates a new View holder.
         *
         * @param view the view
         */
        public ViewHolder(View view) {
            ratingBar = (RatingBar) view.findViewById(R.id.rate_img);
            movieName = (TextView) view.findViewById(R.id.text);
        }
    }

}

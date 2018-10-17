package com.example.vam1994.speedbytedemo;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * The type Rating page.
 */
public class RatingPage extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<FoodItem> adapter;
    private ArrayList<FoodItem> arrayList;
    /**
     * The Context.
     */
    final Context context = this;

    /**
     * ALlow user to rate item upon eating
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_page);
        listView = (ListView)findViewById(R.id.list_view);
        setListData();
        adapter = new ListViewAdapter(this, R.layout.item_listview, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(onItemClickListener());
        Button saveButton = (Button) findViewById(R.id.rating_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Context context = getApplicationContext();
                CharSequence text = "Your rating has been submitted";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();*/

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setMessage("Are you sure?");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(RatingPage.this,
                                        "You have submitted your ratings.",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RatingPage.this, ThreeDiningOptions.class);
                                startActivity(intent);
                            }
                        });

                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

    private AdapterView.OnItemClickListener onItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(RatingPage.this);
                dialog.setContentView(R.layout.layout_dialog);
                dialog.setTitle("Food Item details");

                TextView name = (TextView) dialog.findViewById(R.id.item_name);
                TextView starRate = (TextView) dialog.findViewById(R.id.rate);

                FoodItem movie = (FoodItem) parent.getAdapter().getItem(position);
                name.setText("Food Item name: " + movie.getName());
                starRate.setText("Your rate: " + movie.getRating());

                dialog.show();
            }
        };
    }

    /**
     * Add dummy data to list
     */
    private void setListData() {
        arrayList = new ArrayList<>();
        arrayList.add(new FoodItem(0, "Pizza"));
        arrayList.add(new FoodItem(0, "Cheeseburger"));
        arrayList.add(new FoodItem(0, "Fries"));
        arrayList.add(new FoodItem(0, "Wings"));
        arrayList.add(new FoodItem(0, "Meatballs"));
        arrayList.add(new FoodItem(0, "Ice Cream"));
        arrayList.add(new FoodItem(0, "Drinks"));
    }
}

package com.example.vam1994.speedbytedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * The type Table reservation.
 */
public class TableReservation extends AppCompatActivity {


    /**
     * A textview.
     */
    static TextView tv;
    /**
     * A listview.
     */
    static ListView lv;


    /**
     * Create activity to reserve table
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_reservation);

        lv = (ListView)findViewById(R.id.listView);
        tv = (TextView)findViewById(R.id.textViewNext);

        String[] tables = {"Table 1", "Table 2", "Table 3", "Table 4", "Table 5", "Table 6", "Table 7", "Table 8", "Table 9", "Table 10", "Table 11", "Table 12", "Table 13", "Table 14", "Table 15"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tables);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TableReservation.this, Menu.class);
                startActivity(intent);
            }
        });

        clickText();

    }

    /**
     * Click text.
     */
    public void clickText(){
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableReservation.this, TablesImage.class);
                startActivity(intent);
            }
        });
    }


}

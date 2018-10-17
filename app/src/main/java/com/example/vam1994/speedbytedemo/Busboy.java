package com.example.vam1994.speedbytedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * The type Busboy.
 */
public class Busboy extends NoBackActivity {

    /**
     * A listview.
     */
    ListView lv;

    /**
     * Aloow busboy to see which tables are dirty or clean
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busboy);

        lv = (ListView)findViewById(R.id.listView);

        String[] tables = {"Table 3: Dirty", "Table 4: Dirty", "Table 7: Dirty", "Table 11: Dirty", "Table 15: Dirty"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tables);
        lv.setAdapter(adapter);

    }
}

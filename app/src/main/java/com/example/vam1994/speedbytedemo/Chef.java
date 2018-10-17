package com.example.vam1994.speedbytedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * The type Chef.
 */
public class Chef extends NoBackActivity {

    /**
     * Create Chef Activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef);

        ListView lv = (ListView)findViewById(R.id.listView);

        String[] list = {"Table 3", "Table 5", "Table 1", "Table 10"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);




    }
}

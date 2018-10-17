package com.example.vam1994.speedbytedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * The type Waiter.
 */
public class Waiter extends NoBackActivity {

    /**
     * Instantiate waiter activity with table details
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter);

        ListView lv = (ListView)findViewById(R.id.listView);

        String[] list = {"Table 3: Waiting For Payment", "Table 5: Ready", "Table 4: Ready", "Table 7: Cooking"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

    }
}

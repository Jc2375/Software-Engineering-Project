package com.example.vam1994.whyw8;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;

import com.github.mikephil.charting.data.BarEntry;

/**
 * The type Waiter.
 */
public class Waiter extends NoBackActivity {

    /**
     * Instantiate waiter activity with table details
     * @param savedInstanceState
     */

    /**
     * Clock In/Out Button.
     */
    static Button clockButton;

    boolean clockIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter);

        ListView lv = (ListView)findViewById(R.id.listView);

        String[] list = {"Table 3: Waiting For Payment", "Table 5: Ready", "Table 4: Ready", "Table 7: Cooking"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        clockButton = (Button)findViewById(R.id.clocking);
        clockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date currentTime = Calendar.getInstance().getTime();
                String dateStr = currentTime.toString();
                String[] dateStrArray = dateStr.split(" ");
                if(!clockIn) {
                    clockIn = true;
                    Toast.makeText(getBaseContext(), "Clocked In at "+dateStrArray[3],
                            Toast.LENGTH_LONG).show();
                }
                else{
                    clockIn = false;
                    Toast.makeText(getBaseContext(), "Clocked Out at "+dateStrArray[3],
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
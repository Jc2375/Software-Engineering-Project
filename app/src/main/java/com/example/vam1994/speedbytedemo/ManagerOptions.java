package com.example.vam1994.speedbytedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * The type Manager options.
 */
public class ManagerOptions extends NoBackActivity {

    /**
     * The Ib.
     */
    static ImageButton ib;
    /**
     * The Edit item.
     */
    static Button editItem;
    /**
     * The Edit employee.
     */
    static Button editEmployee;
    /**
     * The Statistics.
     */
    static Button statistics;

    /**
     * Create activity for manager options leading to other activities
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_options);

        ib = (ImageButton)findViewById(R.id.messageButton);
        editItem = (Button)findViewById(R.id.editItemButton);
        editEmployee = (Button)findViewById(R.id.trafficButton);
        statistics = (Button)findViewById(R.id.statisticsButton);

        clickMessage();
        clickEditItem();
        clickEditEmployee();
        clickStatistics();


    }


    /**
     * Click message.
     */
    public void clickMessage(){
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerOptions.this, Message.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Click edit item.
     */
    public void clickEditItem(){
        editItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerOptions.this, ManagerEditItem.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Click edit employee.
     */
    public void clickEditEmployee(){
        editEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerOptions.this, ManagerEditEmployee.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Click statistics.
     */
    public void clickStatistics(){
        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerOptions.this, ManagerStatistics.class);
                startActivity(intent);
            }
        });
    }

}

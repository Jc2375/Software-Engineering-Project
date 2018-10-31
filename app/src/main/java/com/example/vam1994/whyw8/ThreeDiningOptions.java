package com.example.vam1994.whyw8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * The type Three dining options.
 */
public class ThreeDiningOptions extends AppCompatActivity {

    /**
     * The Dine in.
     */
    static Button dineIn;
    static Button viewMenu;
    static Button takeOut;

    /**
     * Give user 3 options to pick from
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_dining_options);

        dineIn = (Button)findViewById(R.id.dineInButton);
        viewMenu = (Button)findViewById(R.id.viewMenuButton);
        takeOut = (Button)findViewById(R.id.takeoutButton);

        clickDineIn();
        clickViewMenu();
        clickTakeOut();
    }

    /**
     * Click dine in.
     */
    public void clickDineIn(){
        dineIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThreeDiningOptions.this, ReservationTime.class);
                startActivity(intent);
            }
        });
    }

    public void clickViewMenu(){
        viewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThreeDiningOptions.this, Menu.class);
                startActivity(intent);
            }
        });
    }

    public void clickTakeOut(){
        takeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThreeDiningOptions.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}

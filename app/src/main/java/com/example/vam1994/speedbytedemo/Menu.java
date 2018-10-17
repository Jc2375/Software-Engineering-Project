package com.example.vam1994.speedbytedemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import butterknife.Bind;

import java.util.ArrayList;

/**
 * The type Menu.
 */
public class Menu extends AppCompatActivity {
    /**
     * The Place order.
     */
    static Button placeOrder;
    /**
     * The List view menu.
     */
    static ListView listViewMenu;

    /**
     * Displays menu and allows to place order
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listViewMenu = (ListView)findViewById(R.id.listViewMenu);
        placeOrder = (Button)findViewById(R.id.placeOrderButton);


        String[] menuItems = {"Cheese Burger-10 min", "Meatballs-12 min", "Pasta-10 min", "French fries-5 min", "Pizza-15 min", "Buffalo Chicken Wings-12 min", "Ice Cream-3 min", "Cool Drinks-3 min"};

        ListAdapter listAdapter = new MenuAdapter(this, menuItems);

        listViewMenu.setAdapter(listAdapter);

        clickPlaceOrder();

    }


    /**
     * Click place order.
     */
    public void clickPlaceOrder(){
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Payment.class);
                startActivity(intent);
            }
        });
    }
}
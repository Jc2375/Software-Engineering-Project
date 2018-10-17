package com.example.vam1994.speedbytedemo;
//new version

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//import com.example.vam1994.speedbytedemo.R;

/**
 * The type Main screen.
 */
public class MainScreen extends AppCompatActivity {

    /**
     * The Customer.
     */
    static Button customer;
    /**
     * The Chef.
     */
    static Button chef;
    /**
     * The Waiter.
     */
    static Button waiter;
    /**
     * The Manager.
     */
    static Button manager;
    /**
     * The Busboy.
     */
    static Button busboy;

    private static String privateKey;
    private static String username;

    /**
     * Instantiates main screen activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        privateKey = getIntent().getExtras().getString("privateKey").toString();
        username = getIntent().getExtras().getString("username").toString();

        customer = (Button)findViewById(R.id.customerButton);
        chef = (Button)findViewById(R.id.chefButton);
        waiter = (Button)findViewById(R.id.waiterButton);
        manager = (Button)findViewById(R.id.managerButton);
        busboy = (Button)findViewById(R.id.busboyButton);

        clickCustomer();
        clickChef();
        clickWaiter();
        clickManager();
        clickBusboy();

    }


    /**
     * CLick busboy.
     */
    public void clickBusboy() {
        busboy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, Busboy.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Click customer.
     */
    public void clickCustomer(){
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, ThreeDiningOptions.class);
                startActivity(intent);
            }
        });
    }


    /**
     * Click chef.
     */
    public void clickChef(){
        chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, Chef.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Click waiter.
     */
    public void clickWaiter(){
        waiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, Waiter.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Click manager.
     */
    public void clickManager(){
        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, ManagerOptions.class);
                startActivity(intent);
            }
        });
    }

}

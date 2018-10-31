package com.example.vam1994.whyw8;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnFailureListener;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

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
    static ArrayList<OrderedItem> ordered;
    static ArrayList<OrderedItem> menu;
    static ListView orderedtotal;
    static Context mcontext;

//    private FirebaseDatabase database;
    /**
     * Displays menu and allows to place order
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
//        database= FirebaseDatabase.getInstance();
//        DatabaseReference databaseReference= database.getReference();
//        databaseReference.child("foodmeny");
        listViewMenu = (ListView) findViewById(R.id.listViewMenu);
        orderedtotal= (ListView) findViewById(R.id.ordered);
        placeOrder = (Button) findViewById(R.id.placeOrderButton);
        ordered= new ArrayList<OrderedItem>();
        //String[] menuItems = {"Cheese Burger-10 min", "Meatballs-12 min", "Pasta-10 min", "French fries-5 min", "Pizza-15 min", "Buffalo Chicken Wings-12 min", "Ice Cream-3 min", "Cool Drinks-3 min"};
        menu= new ArrayList<OrderedItem>();
        OrderedItem cheeseburger = new OrderedItem("Cheese Burger",12.20,0, "10 min");
        OrderedItem meatballs = new OrderedItem("Meatballs",7.35,0, "12 min");
        OrderedItem frenchfies = new OrderedItem("French Fries",4.20,0, "3 min");
//        OrderedItem cheeseburger = new OrderedItem("Cheese Burger",12.2,0);
//        OrderedItem meatballs = new OrderedItem("Meatballs",7.35,0);
//        OrderedItem frenchfies = new OrderedItem("French Fries",4.20,0);
//        OrderedItem cheeseburger = new OrderedItem("Cheese Burger",12.2,0);
//        OrderedItem meatballs = new OrderedItem("Meatballs",7.35,0);
//        OrderedItem frenchfies = new OrderedItem("French Fries",4.20,0);

        menu.add(meatballs);
        menu.add(frenchfies);
        menu.add(cheeseburger);
        mcontext= this;
        ListAdapter listAdapter = new MenuAdapter(this, menu);

        listViewMenu.setAdapter(listAdapter);



        clickPlaceOrder();

    }


    /**
     * Click place order. Total price is also calculated here before changing the scene.
     */
    public void clickPlaceOrder(){
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                double total=0;
                for(int i=0;i<ordered.size();i++){
                    total+= ordered.get(i).quantity*ordered.get(i).price;
                }
                Payment.amount= total;
                Intent intent = new Intent(Menu.this, Payment.class);
                startActivity(intent);
            }
        });
    }


}


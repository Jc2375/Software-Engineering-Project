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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Type;
import java.util.ArrayList;

import java.util.List;
//Below Testing
//import android.widget.GridLayout.LayoutParams;
import android.view.ViewGroup.LayoutParams;

import static android.content.ContentValues.TAG;
//Above Testing

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
    ArrayList<OrderedItem> menu;
    static ListView orderedtotal;
    static Context mcontext;
    static String[] menuItems={"Cheese Burger-10 min", "Meatballs-12 min", "Pasta-10 min", "French fries-5 min", "Pizza-15 min", "Buffalo Chicken Wings-12 min", "Ice Cream-3 min", "Cool Drinks-3 min"};
    //private FirebaseStore database;
    /**
     * Displays menu and allows to place order
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //database= FirebaseDatabase.getInstance()
        //mcontext.getActivity(this)
        listViewMenu = (ListView) findViewById(R.id.listViewMenu);
        orderedtotal= (ListView) findViewById(R.id.ordered);
        placeOrder = (Button) findViewById(R.id.placeOrderButton);
        ordered= new ArrayList<OrderedItem>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Menu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            menu= new ArrayList<OrderedItem>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String name= (String) document.getData().get("Name");
                                String sprice= (String) document.getData().get("Price");
                                double price= Double.parseDouble(sprice); //l.doubleValue();
                                int quantity=0;
                                String ftime= (String) document.getData().get("Time");
                                OrderedItem item= new OrderedItem(name,price,quantity,ftime);
                                menu.add(item);
                                Log.d(TAG, document.getId() + " => " + document.getData()+ "size of menu is: " + menu.size());
                            }
                            ListAdapter listAdapter = new MenuAdapter(Menu.this, menu);

                            listViewMenu.setAdapter(listAdapter);

                            //Below Testing!
                            LayoutParams params = listViewMenu.getLayoutParams();
                            params.width = 600;
                            listViewMenu.setLayoutParams(params);
                            //Above Testing!



                            clickPlaceOrder();
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }

                    }
                });
        /*DocumentReference docRef= db.collection("Menu").document("Cheeseburger");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData().get("Price"));
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });*/


      /* databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                /*for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {

                    Log.v(TAG, "" + childDataSnapshot.child("Cheeseburger").getValue());   //gives the value for given keyname
                }
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });*/
        //databaseReference.child("foodmeny");

        //String[] menuItems = {"Cheese Burger-10 min", "Meatballs-12 min", "Pasta-10 min", "French fries-5 min", "Pizza-15 min", "Buffalo Chicken Wings-12 min", "Ice Cream-3 min", "Cool Drinks-3 min"};
       /* menu= new ArrayList<OrderedItem>();
        OrderedItem cheeseburger = new OrderedItem("Cheese Burger",12.20,0, "10 min");
        OrderedItem meatballs = new OrderedItem("Meatballs",7.35,0, "12 min");
        OrderedItem frenchfies = new OrderedItem("French Fries",4.20,0, "3 min");
        OrderedItem icecream = new OrderedItem("Ice Cream",2.20,0, "1 min");
        OrderedItem milkshake= new OrderedItem("Milkshake",1.00,0,"1 min");
        OrderedItem mozzerella= new OrderedItem("Mozzerella Sticks",1.75,0,"5 min");
        OrderedItem pizza= new OrderedItem("Pizza",1.20,0,"10 min");
        OrderedItem chicken= new OrderedItem("Chicken Tenders",4.00,0,"4 min");
        OrderedItem soda= new OrderedItem("Soda",1.00,0,"1 min");

        menu.add(frenchfies);
        menu.add(mozzerella);
        menu.add(chicken);
        menu.add(meatballs);
        menu.add(pizza);
        menu.add(cheeseburger);
        menu.add(icecream);
        menu.add(milkshake);
        menu.add(soda);
        mcontext= this;
        */


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


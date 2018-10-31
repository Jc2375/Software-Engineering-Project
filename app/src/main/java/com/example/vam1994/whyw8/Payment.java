package com.example.vam1994.whyw8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    /**
     * Payment button
     */
    static Button credit;
    static Button cash;
    static double amount;

    /**
     * Instantiate Payment View
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TextView tv = (TextView)findViewById(R.id.paymentText);
        //Random r = new Random();
        //int amount = r.nextInt(100 - 10) + 10;
        String s= String.format(("%.2f"),amount);
        tv.setText("YOUR TOTAL: $" + s);
        ListView bill = (ListView) findViewById(R.id.bill);
        ArrayAdapter<OrderedItem> adapter = new ArrayAdapter<OrderedItem>(this, android.R.layout.simple_list_item_1, Menu.ordered);
        bill.setAdapter(adapter);


        cash = (Button)findViewById(R.id.cashpay);
        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Payment Confirmed!!!", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(Payment.this, RatingPage.class);
                startActivity(intent);
            }
        });

        credit = (Button)findViewById(R.id.creditpay);
        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Payment Confirmed!!!", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(Payment.this, RatingPage.class);
                startActivity(intent);
            }
        });




    }


}

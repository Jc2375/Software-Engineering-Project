package com.example.vam1994.speedbytedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Payment extends AppCompatActivity {

    /**
     * Payment button
     */
    static Button button;

    /**
     * Instantiate Payment View
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TextView tv = (TextView)findViewById(R.id.paymentText);
        Random r = new Random();
        int amount = r.nextInt(100 - 10) + 10;
        tv.setText("YOUR TOTAL: $" + amount + ".00");


        button = (Button)findViewById(R.id.payButton);
        clickButton();

    }

    /**
     * Set click-listener for button
     */
    public void clickButton(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Payment Confirmed!!!", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(Payment.this, RatingPage.class);
                startActivity(intent);
            }
        });
    }

}

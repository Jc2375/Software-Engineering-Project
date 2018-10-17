package com.example.vam1994.speedbytedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * The type Message.
 */
public class Message extends AppCompatActivity {


    /**
     * The To spinner.
     */
    static Spinner toSpinner;
    /**
     * The Message spinner.
     */
    static Spinner messageSpinner;
    /**
     * The Send button.
     */
    static Button send;

    /**
     * Instantiates message activity screen with drop-down spinners
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        send = (Button)findViewById(R.id.sendButton);

        toSpinner = (Spinner)findViewById(R.id.spinnerTo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.To, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(adapter);

        messageSpinner = (Spinner)findViewById(R.id.spinnerMessage);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Message, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        messageSpinner.setAdapter(adapter2);

        clickButton();

    }

    private void clickButton() {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Message.this, "Message Sent", Toast.LENGTH_LONG).show();
            }
        });
    }


}

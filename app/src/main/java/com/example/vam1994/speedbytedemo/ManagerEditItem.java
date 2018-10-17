package com.example.vam1994.speedbytedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.Bind;

/**
 * The type Manager edit item.
 */
public class ManagerEditItem extends AppCompatActivity {

    @Bind(R.id.nameInput) EditText nameText;
    @Bind(R.id.priceInput) EditText priceText;
    @Bind(R.id.timeInput) EditText timeText;

    String name;
    /**
     * The Add.
     */
    static Button add;
    /**
     * The Delete.
     */
    static Button delete;

    /**
     * Create an activity for manager edit item
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_edit_item);

        add = (Button)findViewById(R.id.addButton);
        delete = (Button)findViewById(R.id.deleteButton);

        clickAdd();
        clickDelete();

    }

    /**
     * Click add.
     */
    public void clickAdd(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ManagerEditItem.this, "Item Added", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ManagerEditItem.this, ManagerOptions.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Click delete.
     */
    public void clickDelete(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ManagerEditItem.this, "Item Deleted", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ManagerEditItem.this, ManagerOptions.class);
                startActivity(intent);
            }
        });
    }

}

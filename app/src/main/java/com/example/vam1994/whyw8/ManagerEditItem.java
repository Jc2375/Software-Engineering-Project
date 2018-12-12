package com.example.vam1994.whyw8;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;

import static android.content.ContentValues.TAG;

/**
 * The type Manager edit item.
 */
public class ManagerEditItem extends AppCompatActivity {

    //@Bind(R.id.nameInput) EditText nameText;
    //@Bind(R.id.priceInput) EditText priceText;
    //@Bind(R.id.timeInput) EditText timeText;
    //EditText nsmeText, priceText, timeText;
    static FirebaseFirestore db;
    String name;
    /**
     * The Add.
     */
    static Button add;
    /**
     * The Delete.
     */
    static Button delete;
    static EditText nameText;
    static EditText priceText;
    static EditText timeText;
    /**
     * Create an activity for manager edit item
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_edit_item);

        nameText = (EditText) findViewById(R.id.nameInput);
        priceText = (EditText)findViewById(R.id.priceInput);
        timeText = (EditText) findViewById(R.id.timeInput);
        add = (Button)findViewById(R.id.addButton);
        delete = (Button)findViewById(R.id.deleteButton);
        db = FirebaseFirestore.getInstance();
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
                String foodname= ManagerEditItem.nameText.getText().toString();
                String time= ManagerEditItem.timeText.getText().toString();
                String price= ManagerEditItem.priceText.getText().toString();
                // Create a new user with a first and last name
                Map<String, Object> user = new HashMap<>();
                user.put("Name", foodname);
                user.put("Time", time);
                user.put("Price",price);

                // Add a new document with a generated ID
                db.collection("Menu")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });

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

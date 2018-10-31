package com.example.vam1994.whyw8;

/**
 * Created by sdimitrovski95
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * The type Login activity.
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    //private ProgressBar progressBar;
    FirebaseAuth auth;

    /**
     * The Email text.
     */
    @Bind(R.id.input_email) EditText emailText;
    /**
     * The Password text.
     */
    @Bind(R.id.input_password) EditText passwordText;
    /**
     * The Login button.
     */
    @Bind(R.id.btn_login) Button loginButton;
    /**
     * The Signup link.
     */
    @Bind(R.id.link_signup) TextView signupLink;


    /**
     * Allow user to login
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        auth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailText.getText().toString();
                final String password = passwordText.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        // progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (!passwordChecked()) {
                                passwordText.setError("Minimum Password Length is 6 Characters");
                            } else {
                                onLoginFailed();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                            if(email.equals("customer@mail.com")){
                                Intent intent = new Intent(LoginActivity.this, ThreeDiningOptions.class);
                                startActivity(intent);
                            }

                            else if(email.equals("chef@mail.com")){
                                Intent intent = new Intent(LoginActivity.this, Chef.class);
                                startActivity(intent);
                            }

                            else if(email.equals("manager@mail.com")){
                                Intent intent = new Intent(LoginActivity.this, ManagerOptions.class);
                                startActivity(intent);
                            }

                            else if(email.equals("waiter@mail.com")){
                                Intent intent = new Intent(LoginActivity.this, Waiter.class);
                                startActivity(intent);
                            }

                            else if(email.equals("busboy@mail.com")){
                                Intent intent = new Intent(LoginActivity.this, Busboy.class);
                                startActivity(intent);
                            }

                            else{
                                Toast.makeText(getApplicationContext(), "User not registered with base", Toast.LENGTH_LONG);
                            }

                            finish();
                        }
                    }
                });
            }
        });

        signupLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    /**
     * If login failed.
     */
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed!", Toast.LENGTH_LONG).show();

        loginButton.setEnabled(true);
    }

    /**
     * Check user password
     *
     * @return whether or not password check was successful
     */
    public boolean passwordChecked(){
        boolean isValid = true;

        String mailId = emailText.getText().toString();
        String pass = passwordText.getText().toString();

        if(mailId.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(mailId).matches()){
            emailText.setError("please enter a valid email address");
            isValid = false;
        }

        else{
            emailText.setError(null);
        }

        if(pass.isEmpty() || pass.length() < 6 || pass.length() > 12){
            passwordText.setError("password must be between 8 and 12 alphanumeric characters");
            isValid = false;
        }

        else{
            passwordText.setError(null);
        }

        return isValid;
    }

}
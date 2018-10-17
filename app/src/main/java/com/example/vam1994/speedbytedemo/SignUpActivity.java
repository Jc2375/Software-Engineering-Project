package com.example.vam1994.speedbytedemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tillu on 4/18/2017.
 */
public class SignUpActivity extends AppCompatActivity{

    private static final String TAG = "Signup Activity";

    /**
     * The Name text.
     */
    @Bind(R.id.input_name) EditText nameText;
    /**
     * The Address text.
     */
    @Bind(R.id.input_address) EditText addressText;
    /**
     * The Email text.
     */
    @Bind(R.id.input_email) EditText emailText;
    /**
     * The Phone text.
     */
    @Bind(R.id.input_phone) EditText phoneText;
    /**
     * The Password text.
     */
    @Bind(R.id.input_password) EditText passwordText;
    /**
     * The Re enter password text.
     */
    @Bind(R.id.input_reEnterPassword) EditText reEnterPasswordText;
    /**
     * The Signup button.
     */
    @Bind(R.id.btn_signup) Button signupButton;
    /**
     * The Login link.
     */
    @Bind(R.id.link_login) TextView loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        signupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                signUp();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    /**
     * Sign up.
     */
    public void signUp(){
        Log.d(TAG, "Signup");

        if(!checked()){
            onSignUpFailed();
            return;
        }

        signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = nameText.getText().toString();
        String address = addressText.getText().toString();
        String email = emailText.getText().toString();
        String mobile = phoneText.getText().toString();
        String password = passwordText.getText().toString();
        String reEnterPassword = reEnterPasswordText.getText().toString();

        //SIGNUP LOGIC HERE//
        //ADD TO DATABASE LIKELY//

        new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        onSignUpSuccess();
                        progressDialog.dismiss();
                    }
                }, 3000
        );

    }

    /**
     * If sign up success.
     */
    public void onSignUpSuccess(){
        signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    /**
     * If sign up failed.
     */
    public void onSignUpFailed(){
        Toast.makeText(getBaseContext(), "MainScreen Failed", Toast.LENGTH_LONG).show();
        signupButton.setEnabled(true);
    }

    /**
     * Checked boolean.
     *
     * @return the boolean
     */
    public boolean checked(){
        boolean isValid = true;

        String name = nameText.getText().toString();
        String address = addressText.getText().toString();
        String email = emailText.getText().toString();
        String mobile = phoneText.getText().toString();
        String password = passwordText.getText().toString();
        String reEnterPassword = reEnterPasswordText.getText().toString();

        if(name.isEmpty() || name.length() < 3){
            nameText.setError("Name must be at least 3 characters!");
            isValid = false;
        }
        else{
            nameText.setError(null);
        }

        if(address.isEmpty()){
            addressText.setError("Please enter a valid address");
            isValid = false;
        }
        else{
            addressText.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("Please enter a valid email address");
            isValid = false;
        }
        else {
            emailText.setError(null);
        }

        if (mobile.isEmpty() || mobile.length()!=10) {
            phoneText.setError("Please enter a valid phone number");
            isValid = false;
        }
        else {
            phoneText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 8 and 12 alphanumeric characters");
            isValid = false;
        }
        else {
            passwordText.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 8 || reEnterPassword.length() > 12 || !(reEnterPassword.equals(password))) {
            reEnterPasswordText.setError("Password Do not match");
            isValid = false;
        } else {
            reEnterPasswordText.setError(null);
        }

        return isValid;
    }
}
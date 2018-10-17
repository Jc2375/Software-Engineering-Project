package com.example.vam1994.speedbytedemo;

/**
 * Created by tillu on 4/18/2017.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * The type Login activity.
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    public static String pass = "", mailId = "";

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

    public static class LoginOutput {
        int status;
        String result;
    }

    /**
     * Allow user to login
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                login();
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

    /**
     * Login.
     */
   /* public void login(){
        Log.d(TAG, "MainScreen");

        if(!passwordChecked()){
            onLoginFailed();
            return;
        }

        loginButton.setEnabled(false); //find me1 sss

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);//this is cool
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating User...");
        progressDialog.show();

        String mailId = emailText.getText().toString();
        String pass = passwordText.getText().toString();

        //ADD AUTHENTICATION LOGIC HERE//
        //CHECK USERS AGAINST DATABASE//

        new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        onLoginSuccess();
                        progressDialog.dismiss();
                    }
                }, 3000
        );
    }*/

    /**
     * Initiate Login.
     */
    public void login() {
        if (passwordChecked()) {
            loginButton.setEnabled(false); //find me1 sss

            final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);//this is cool
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Authenticating User...");
            progressDialog.show();

            mailId = emailText.getText().toString();
            pass = passwordText.getText().toString();

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        @Override
                        public void run() {
                            Log.d(TAG, "Got here");
                            new AsyncTask<Void,Void,LoginOutput>() {
                                public LoginOutput doInBackground(Void... args) {
                                    HttpURLConnection conn = null;
                                    LoginOutput output = null;
                                    try {
                                        URL url = new URL("http://adapter.cs.rutgers.edu:3000/login");
                                        conn = (HttpURLConnection) url.openConnection();
                                        conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
                                        conn.setRequestProperty("Accept","application/json; charset=UTF-8");
                                        //conn.setRequestProperty("keep-alive","true");
                                        //conn.setConnectTimeout(5000);
                                        conn.setDoInput(true);
                                        conn.setDoOutput(true);
                                        conn.setRequestMethod("POST");
                                        LoginServerRequest req = new LoginServerRequest();
                                        req.password = pass;
                                        req.username = mailId;
                                        Gson gson = new Gson();
                                        String body = gson.toJson(req);
                                        Log.d(TAG,"!!!BODY!!! " + body);
                                        conn.connect();
                                        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                                        wr.write(body);
                                        wr.flush();
                                        InputStream is = conn.getInputStream();
                                        InputStreamReader isr = new InputStreamReader(is);
                                        BufferedReader reader = new BufferedReader(isr);
                                        // BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                                        StringBuilder builder = new StringBuilder();
                                        String str = reader.readLine();
                                        while (str != null) {
                                            builder.append(str);
                                            str = reader.readLine();
                                        }
                                        String result = builder.toString();
                                        // String result = conn.getResponseMessage();
                                        output = new LoginOutput();
                                        output.status = conn.getResponseCode();
                                        output.result = result;
                                    } catch(MalformedURLException e) {
                                        Log.d(TAG, "!!!ERROR!!! Malformed URL");
                                    } catch (IOException e) {
                                        Log.d(TAG, "!!!ERROR!!! IO Exception");
                                    } finally {
                                        if (conn != null) conn.disconnect();
                                    }
                                    return output;
                                }

                                public void onPostExecute(LoginOutput result) {
                                    if (result != null && result.status == 200) {
                                        if(mailId.equals("tim@mail.com")){
                                            Log.d(TAG, "!!!RESULT!!!" + result.result);
                                            Intent intent = new Intent(LoginActivity.this, ThreeDiningOptions.class);
                                            intent.putExtra("username",mailId);
                                            intent.putExtra("privateKey",result.result);
                                            startActivity(intent);
                                        }

                                        else if(mailId.equals("chef@mail.com")){
                                            Log.d(TAG, "!!!RESULT!!!" + result.result);
                                            Intent intent = new Intent(LoginActivity.this, Chef.class);
                                            intent.putExtra("username",mailId);
                                            intent.putExtra("privateKey",result.result);
                                            startActivity(intent);
                                        }

                                        else if(mailId.equals("manager@mail.com")){
                                            Log.d(TAG, "!!!RESULT!!!" + result.result);
                                            Intent intent = new Intent(LoginActivity.this, ManagerOptions.class);
                                            intent.putExtra("username",mailId);
                                            intent.putExtra("privateKey",result.result);
                                            startActivity(intent);
                                        }

                                        else if(mailId.equals("waiter@mail.com")){
                                            Log.d(TAG, "!!!RESULT!!!" + result.result);
                                            Intent intent = new Intent(LoginActivity.this, Waiter.class);
                                            intent.putExtra("username",mailId);
                                            intent.putExtra("privateKey",result.result);
                                            startActivity(intent);
                                        }

                                        else if(mailId.equals("busboy@mail.com")){
                                            Log.d(TAG, "!!!RESULT!!!" + result.result);
                                            Intent intent = new Intent(LoginActivity.this, Busboy.class);
                                            intent.putExtra("username",mailId);
                                            intent.putExtra("privateKey",result.result);
                                            startActivity(intent);
                                        }

                                        else{
                                            Log.d(TAG, "Not an acceptable login");
                                            Toast.makeText(getApplicationContext(), "User not registered with base", Toast.LENGTH_LONG);
                                        }
                                        // pass result.result as privateKey to the next activity along with username
                                    } else {
                                        Log.d(TAG, "!!!RESULT!!!: Error.");
                                        loginButton.setEnabled(true);
                                    }
                                }
                            }.execute();
                            progressDialog.dismiss();
                        }
                    }, 3000
            );
        } else {
            // error message
            onLoginFailed();
        }
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

        if(pass.isEmpty() || pass.length() < 8 || pass.length() > 12){
            passwordText.setError("password must be between 8 and 12 alphanumeric characters");
            isValid = false;
        }

        else{
            passwordText.setError(null);
        }

        return isValid;
    }

}
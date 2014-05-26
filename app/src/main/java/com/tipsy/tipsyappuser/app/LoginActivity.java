package com.tipsy.tipsyappuser.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


/**
 * Created by Bastien on 20/05/2014.
 */
public class LoginActivity extends Activity {

    Button loginbutton;
    Button signup;
    String usermailtxt;
    String userpasswordtxt;
    EditText userPassword;
    EditText usermail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         usermail = (EditText) findViewById(R.id.user_mail);
        userPassword = (EditText) findViewById(R.id.user_password);

        loginbutton = (Button) findViewById(R.id.button_login);
        signup = (Button) findViewById(R.id.button_signup);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usermailtxt = usermail.getText().toString();
                userpasswordtxt = userPassword.getText().toString();

                if (usermail.getText().toString().length() == 0)
                    usermail.setError("mail is required");
                else if (Patterns.EMAIL_ADDRESS.matcher(usermail.getText().toString()).matches())
                    usermail.setError("mail is wrong");
                else {
                    ParseUser.logInInBackground(usermailtxt, userpasswordtxt, new LogInCallback() {
                        public void done(ParseUser user, ParseException e) {
                            if (user != null) {
                                // If user exist and authenticated, send user to home.class
                                Intent intent = new Intent(
                                        LoginActivity.this,
                                        HomeActivity.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(),
                                        "Successfully Logged in",
                                        Toast.LENGTH_LONG).show();
                                finish();
                            } else {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "No such user exist, please signup",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                }
            }
        });

        // Sign up Button Click Listener
        signup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(
                        LoginActivity.this,
                        RegisterActivity.class);
                startActivity(intent);


            }


        });

    }

}
package com.tipsy.tipsyappuser.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.tipsy.tipsyappuser.app.ParseApplication;
/**
 * Created by Bastien on 20/05/2014.
 */
public class LoginActivity extends Activity {

    Button loginbutton;
    Button signup;
    String usermailtxt;
    String userPasswordtxt;
    EditText userPassword;
    EditText usermail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         usermail = (EditText) findViewById(R.id.user_mail);
        userPassword = (EditText) findViewById(R.id.user_password);

        loginbutton = (Button) findViewById(R.id.button_login);
        //signup = (Button) findViewById(R.id.button_signup);

     /*   if( usermail.getText().toString().length() == 0 )
            usermail.setError( "mail is required" );
        else if ( Patterns.EMAIL_ADDRESS.matcher(usermail.getText().toString()).matches())
            usermail.setError( "mail is wrong" );
*/


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              usermailtxt=usermail.getText().toString();
              userPasswordtxt=userPassword.getText().toString();

                ParseUser.logInInBackground(usermailtxt, userPasswordtxt, new LogInCallback() {
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
        });
    }

}
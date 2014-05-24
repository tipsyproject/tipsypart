package com.tipsy.tipsyappuser.app;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import com.parse.Parse;
import com.parse.ParseUser;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ParseUser user = ParseUser.getCurrentUser();
        if (user == null)
            startActivity(new Intent(this, LoginActivity.class));
        else
            startActivity(new Intent(this, HomeActivity.class));


    }

}

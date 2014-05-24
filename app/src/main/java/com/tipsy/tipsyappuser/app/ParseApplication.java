package com.tipsy.tipsyappuser.app;
import  com.parse.Parse;
import android.app.Application;

/**
 * Created by Bastien on 24/05/2014.
 */

public class ParseApplication extends Application {

    @Override
    public void onCreate() {

        // Add your initialization code here
        Parse.initialize(this, "JPFVbZ1ZrEVHZD88TVhNjAeYvDoUxz8g92VvjDLN", "pe7xuKRzYIK94w2g3haQfXUXbbbRsIpnwMeC8Xik");


    }

}
package com.driverbuddy.costeiu.driverbuddy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import com.driverbuddy.costeiu.driverbuddy.slidingmenu.controler.SlideMenuActivity;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Determine whether the current user is an anonymous user
        if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
            Intent intent = new Intent(MainActivity.this, LoginSignupActivity.class);
            startActivity(intent);
            finish();
        } else {
            //If current user is NOt anonymous user
            ParseUser currentUser = ParseUser.getCurrentUser();
            if (currentUser != null) {
                // Send user in SlideMenuActivity.class
                Intent intent = new Intent(MainActivity.this, SlideMenuActivity.class);
                startActivity(intent);
                finish();
            } else {
                // Send user to LoginSignupActivity.class
                Intent intent = new Intent(MainActivity.this, LoginSignupActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}

package com.driverbuddy.costeiu.driverbuddy;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Costeiu on 3/1/2015.
 */
public class ParseAplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        Parse.initialize(this, "DHjp6GVHEuOOuOiLvErPejFnDz0p6OyAKBCcbkk0", "2ws1GeTKP88weD98xNiYyFqIHpY0D0q0mySCKNWd");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        ParseACL.setDefaultACL(defaultACL, true);
    }
}

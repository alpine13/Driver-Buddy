package com.driverbuddy.costeiu.driverbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.driverbuddy.costeiu.driverbuddy.slidingmenu.controler.SlideMenuActivity;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by Costeiu on 3/1/2015.
 */
public class LoginSignupActivity extends Activity {

    // Declare Variables
    Button loginbutton;
    String usernametxt;
    String passwordtxt;
    TextView signup;
    EditText password;
    EditText username;



    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from main.xml
        setContentView(R.layout.loginsignup);
        // Locate EditTexts in main.xml
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        // Locate Buttons in main.xml
        loginbutton = (Button) findViewById(R.id.login);

        // Locate signup TextView in main.xml
        signup = (TextView)findViewById(R.id.signuptxt);

        // Signup Click Listener
        signup.setOnClickListener(new OnClickListener(){

            public void onClick(View arg0) {
                Intent intent = new Intent(LoginSignupActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Login Button Click Listener
        loginbutton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();

                // Send data to Parse.com for verification
                ParseUser.logInInBackground(usernametxt, passwordtxt,
                        new LogInCallback() {
                            public void done(ParseUser user, ParseException e) {
                                if (user != null) {
                                    // If user exist and authenticated, send user to SlideMenuActivity.class
                                    Intent intent = new Intent(
                                            LoginSignupActivity.this,
                                            SlideMenuActivity.class);
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

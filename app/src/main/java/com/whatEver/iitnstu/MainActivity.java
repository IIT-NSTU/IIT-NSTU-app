package com.whatEver.iitnstu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * This is the initial activity.
 * This activity start when the start.
 *
 * When the will start first time on a device this activity redirect the users to
 * different activity based on their state.
 *
 * Also It has a splash window. Which will disappear after 1.5 seconds.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* splash window */
        getWindow().setStatusBarColor(this.getResources().getColor(R.color.white, null));
        new Handler().postDelayed(() -> {
            ////here auth with if/else
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            } else {
                Intent homeIntent = new Intent(MainActivity.this, AuthenticationActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, 1500);

    }
}

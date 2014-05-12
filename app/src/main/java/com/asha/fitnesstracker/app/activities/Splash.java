package com.asha.fitnesstracker.app.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.asha.fitnesstracker.app.R;


public class Splash extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finishSplash();
            }
        }, 3000);
    }

    private void finishSplash() {
        Intent intent;
        intent = new Intent(this, SocialLogin.class);
        finish();
        startActivity(intent);
    }


}

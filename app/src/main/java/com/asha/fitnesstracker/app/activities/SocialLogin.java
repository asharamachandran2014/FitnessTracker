package com.asha.fitnesstracker.app.activities;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.asha.fitnesstracker.app.R;
import com.asha.fitnesstracker.app.fragment.LoginFragment;


public class SocialLogin extends ActionBarActivity implements View.OnClickListener{

    private LoginFragment mainFragment;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_login);
        skip = (TextView) findViewById(R.id.skip);
        skip.setOnClickListener(this);

        if (savedInstanceState == null) {
            // Add the fragment on initial activity setup
            mainFragment = new LoginFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, mainFragment)
                    .commit();
        } else {
            // Or set the fragment from restored state info
            mainFragment = (LoginFragment) getSupportFragmentManager()
                    .findFragmentById(android.R.id.content);
        }


    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.skip){

            Intent main = new Intent(SocialLogin.this,MainScreen.class);
            finish();
            startActivity(main);
        }
    }
}

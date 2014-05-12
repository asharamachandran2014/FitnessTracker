package com.asha.fitnesstracker.app.activities;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.asha.fitnesstracker.app.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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

    @Override
    protected void onResume() {
        super.onResume();
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.asha.fitnesstracker.app",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}

package com.asha.fitnesstracker.app.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import com.asha.fitnesstracker.app.R;

public class Tips extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        WebView webview = (WebView)findViewById(R.id.webview);
        webview.setHorizontalScrollBarEnabled(false);
        webview.loadUrl("file:///android_asset/tips.html");
    }


}

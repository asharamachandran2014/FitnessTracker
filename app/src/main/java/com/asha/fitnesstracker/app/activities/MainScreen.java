package com.asha.fitnesstracker.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.asha.fitnesstracker.app.R;

public class MainScreen extends Activity implements View.OnClickListener {

    ImageView bmi,calorie,tips,reports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        bmi = (ImageView) findViewById(R.id.bmi_btn);
        calorie = (ImageView) findViewById(R.id.calorie_btn);
        tips = (ImageView) findViewById(R.id.Tips_btn);
        reports = (ImageView) findViewById(R.id.Reports_btn);

        bmi.setOnClickListener(this);
        calorie.setOnClickListener(this);
        tips.setOnClickListener(this);
        reports.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bmi_btn:
                Intent i = new Intent(MainScreen.this,BmiCalculator.class);
                startActivity(i);
                break;

            case R.id.calorie_btn:
                Intent calorie = new Intent(MainScreen.this,Calorie.class);
                startActivity(calorie);
                break;

            case R.id.Tips_btn:
                Intent tips = new Intent(MainScreen.this,Tips.class);
                startActivity(tips);
                break;

            case R.id.Reports_btn:
                break;


        }
    }
}

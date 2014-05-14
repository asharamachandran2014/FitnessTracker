package com.asha.fitnesstracker.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.asha.fitnesstracker.app.R;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_home)
        {
            startActivity(new Intent(this,MainScreen.class));
        }else if(id == R.id.action_bmi){
            startActivity(new Intent(this,BmiCalculator.class));

        }else if(id == R.id.action_calorie){
            startActivity(new Intent(this,Calorie.class));

        }else if(id == R.id.action_tips){
            startActivity(new Intent(this,Tips.class));

        }else if(id == R.id.action_reports){
            startActivity(new Intent(this,Report.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

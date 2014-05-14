package com.asha.fitnesstracker.app.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.asha.fitnesstracker.app.R;

public class CalorieResult extends BaseActivity {

    String result,name,myHealth;
    Float myValue;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_result);

        textViewResult = (TextView) findViewById(R.id.textResult);

        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("strResult")!=null&&bundle.getString("strName")!=null){
            result = bundle.getString("strResult");
            name = bundle.getString("strName");
            textViewResult.setText("Hi "+name+" Your BMR is "+result);
        }
        else{
            textViewResult.setText("We are not able to show your BMR.");
        }
    }

}

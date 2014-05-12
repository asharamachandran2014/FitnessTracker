package com.asha.fitnesstracker.app.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.asha.fitnesstracker.app.R;

public class BmiResult extends Activity {

    String result,name,myHealth;
    Float myValue;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        textViewResult = (TextView) findViewById(R.id.textResult);

        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("strResult")!=null&&bundle.getString("strName")!=null){
            result = bundle.getString("strResult");
            myHealth = myResult();

            name = bundle.getString("strName");
            textViewResult.setText("Hi "+name+" Your BMI is "+result+".\n You are "+myHealth);
        }
        else{
            textViewResult.setText("We are not able to show your BMI.");
        }


    }

    private String myResult() {
        myValue = Float.parseFloat(result);
        if(myValue<=18.5){
            myHealth = "UnderWeight";
        }else if(myValue<=23){
            myHealth = "Normal";
        }else if(myValue<=30){
            myHealth = "OverWeight";
        }else{
            myHealth = "Obese";
        }
        return myHealth;
    }


}

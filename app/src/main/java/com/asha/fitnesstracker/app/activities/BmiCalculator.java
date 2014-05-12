package com.asha.fitnesstracker.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.asha.fitnesstracker.app.R;

import java.math.BigDecimal;

public class BmiCalculator extends Activity implements View.OnClickListener{

    EditText textName,textHeight,textWeight,textAge;
    Switch switchGender;
    Button buttonSubmit;
    BigDecimal result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        textName = (EditText) findViewById(R.id.editName);
        textHeight = (EditText) findViewById(R.id.editHeight);
        textWeight = (EditText) findViewById(R.id.editWeight);
        textAge = (EditText) findViewById(R.id.editAge);
        switchGender = (Switch) findViewById(R.id.editGender);
        buttonSubmit = (Button) findViewById(R.id.submit);

       buttonSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.submit){
            validateInputs();
        }

    }

    private boolean checkNotEmpty(EditText editText) {
        return TextUtils.isEmpty(editText.getText().toString());
    }

    private void validateInputs() {

        if(checkNotEmpty(textName)){
            Toast.makeText(this, "Name cant be blank", Toast.LENGTH_LONG).show();
        }else if(checkNotEmpty(textAge)){
            Toast.makeText(this, "Age cant be blank", Toast.LENGTH_LONG).show();
        }else if(checkNotEmpty(textWeight)){
            Toast.makeText(this, "Weight cant be blank", Toast.LENGTH_LONG).show();
        }else if(checkNotEmpty(textHeight)){
            Toast.makeText(this, "Height cant be blank", Toast.LENGTH_LONG).show();
        }else if(textAge.getText().toString().equals("0")|textAge.getText().toString().equals("00")){
            Toast.makeText(this, "Age cant be 0", Toast.LENGTH_LONG).show();
        }else{
            calculateBmi();
        }
    }

    private void calculateBmi() {


        Float bmiValue,weightValue,heightValue;

        weightValue = Float.parseFloat(textWeight.getText().toString());
        heightValue = Float.parseFloat(textHeight.getText().toString());
        heightValue = heightValue/100;

        bmiValue = weightValue/(heightValue*heightValue);

        result=round(bmiValue,2);

        Intent bmi = new Intent(BmiCalculator.this,BmiResult.class);
        String myResult = result.toString();
        bmi.putExtra("strResult",myResult);
        bmi.putExtra("strName",textName.getText().toString().trim());
        startActivity(bmi);


    }

    public static BigDecimal round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd;
    }
}

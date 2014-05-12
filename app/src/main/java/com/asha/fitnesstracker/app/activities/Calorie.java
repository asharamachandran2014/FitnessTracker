package com.asha.fitnesstracker.app.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.asha.fitnesstracker.app.R;

import java.math.BigDecimal;

public class Calorie extends Activity implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    private Spinner spinner;
    private EditText textName,textAge,textWeight,textHeight;
    private Switch switchGender;
    private Float myWeight;
    private Float myAge;
    private Float myHeight;
    private float myBmr;
    private Button buttonSubmit;
    private Integer check=0;
    private float pExcercise= (float) 1.0;
    BigDecimal result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        textAge = (EditText) findViewById(R.id.editAge);
        textName = (EditText) findViewById(R.id.editName);
        textHeight = (EditText) findViewById(R.id.editHeight);
        textWeight = (EditText) findViewById(R.id.editWeight);
        buttonSubmit = (Button) findViewById(R.id.submit);
        switchGender = (Switch) findViewById(R.id.editGender);

        switchGender.setOnCheckedChangeListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position==0){
            pExcercise= (float) 1.2;
        }else if(position==1){
            pExcercise= (float) 1.55;
        }else if(position==2){
            pExcercise= (float) 1.725;
        }else if(position==3){
            pExcercise= (float) 1.9;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        pExcercise= (float) 1.2;
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
            calculateBmr();
        }
    }

    private void calculateBmr() {

        myAge = Float.parseFloat(String.valueOf(textAge.getText()));
        myHeight = Float.parseFloat(String.valueOf(textHeight.getText()));
        myWeight = Float.parseFloat(String.valueOf(textWeight.getText()));

        if(check==1){
            myBmr = (float) (655+(9.6*myWeight)+(1.8*myHeight)-(4.7*myAge)*pExcercise);
            result = round(myBmr,1);
        }
        else{
            myBmr = (float) (66+(13.7*myWeight)+(5*myHeight)-(6.8*myAge)*pExcercise);
            result = round(myBmr,1);
        }

        Toast.makeText(this,"BMR is -- "+result+" I AM "+switchGender.getText(),Toast.LENGTH_LONG).show();
    }

    public void bmronClick(View v){

       validateInputs();

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
            check=0;
        } else {
            check=1;
        }
    }

    public static BigDecimal round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd;
    }
}

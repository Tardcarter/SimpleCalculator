package com.example.SimpleCalculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private TextView previousCalculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView((R.layout.activity_main));


        previousCalculation = findViewById(R.id.previousCalculation);
        display= findViewById(R.id.textView);

        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        }));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getActionBar().hide();
        } else {
            getActionBar().show();
        }
    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + strToAdd.length());
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos+ strToAdd.length());
        }

    }

    public void zeroBTN(View view) {
        updateText("0");
    }

    public void oneBTN(View view) {
        updateText("1");
    }

    public void twoTN(View view) {
        updateText("2");
    }

    public void threeBTN(View view) {
        updateText("3");
    }

    public void fourBTN(View view) {
        updateText("4");
    }

    public void fiveBTN(View view) {
        updateText("5");
    }

    public void sixBTN(View view) {
        updateText("6");
    }

    public void sevenBTN(View view) {
        updateText("7");
    }

    public void eightBTN(View view) {
        updateText("8");
    }

    public void nineBTN(View view) {
        updateText("9");
    }

    public void addBTN(View view) {
        updateText("+");
    }

    public void minusBTN(View view) {
        updateText("-");
    }

    public void timesBTN(View view) {
        updateText("×");
    }

    public void divideBTN(View view) {
        updateText("÷");
    }

    public void decimalBTN(View view) {
        updateText(".");
    }

    public void historyBTN(View view) {
        updateText("");
    }

    public void equalBTN(View view) {
        String userExp=display.getText().toString();

        previousCalculation.setText(userExp);
        userExp=userExp.replaceAll("÷","/");
        userExp=userExp.replaceAll("×","*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }
    public void logBTN(View view){
        updateText("log(");
    }

    public void sinBTN(View view){
        updateText("sin(");
    }

    public void cosBTN(View view){
        updateText("cos(");
    }

    public void tanBTN(View view){
        updateText("tan(");
    }

    public void asinBTN(View view){
        updateText("arcsin(");
    }

    public void acosBTN(View view){
        updateText("arccos(");
    }

    public void atanBTN(View view){
        updateText("atan(");
    }

    public void piBTN(View view){
        updateText("3.14");
    }

    public void lnBTN(View view){
        updateText("ln(");
    }

    public void closeBTN(View view){
        updateText(")");
    }

    public void squaredBTN(View view){
        updateText("^2");
    }

    public void cubedBTN(View view){
        updateText("^3");
    }

    public void sqrtRootBTN(View view){
        updateText("");
    }

    public void openBTN(View view){
        updateText("(");
    }

    public void yFunctionBTN(View view){
        updateText("y^");
    }

    public void xInverseBTN(View view){
        updateText("1/x");
    }

    public void clearBTN(View view) {
        display.setText("");
    }

    public void negativeBTN(View view) {
        updateText("-");
    }

    public void storeABTN(View view) {
        updateText("0");
    }

    public void storeBBTN(View view) {
        updateText("0");
    }

    public void recallABTN(View view) {
        updateText("0");
    }

    public void recallBBTN(View view) {
        updateText("0");
    }
}

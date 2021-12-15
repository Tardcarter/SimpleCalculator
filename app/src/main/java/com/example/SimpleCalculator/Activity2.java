package com.example.SimpleCalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.SimpleCalculator.R;

public class Activity2 extends AppCompatActivity {

    private EditText display;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private Button button;
    private Button colorBtn;
    private Boolean altColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_2));

        sp = this.getSharedPreferences("save.dat", MODE_PRIVATE);
        edit = sp.edit();
        altColor = sp.getBoolean("altcolor", false);

        button=(Button) findViewById(R.id.mainBTN);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity();
            }
        });

        colorBtn=(Button) findViewById(R.id.colorBTN);
        colorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(altColor){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    altColor = false;
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    altColor = true;
                }
                edit.putBoolean("altcolor", altColor);
                edit.apply();
            }
        });

    }
    public void MainActivity(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);

    }}


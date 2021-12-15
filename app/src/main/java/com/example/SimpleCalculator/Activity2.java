package com.example.SimpleCalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.SimpleCalculator.R;

public class Activity2 extends AppCompatActivity {

    private EditText display;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_main));

        button=(Button) findViewById(R.id.mainBTN);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

    }
    public void MainActivity(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);

    }


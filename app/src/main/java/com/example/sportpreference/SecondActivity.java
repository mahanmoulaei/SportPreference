package com.example.sportpreference;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewName, textViewSport;
    Button btnReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initialize();
    }

    private void initialize() {
        textViewName = findViewById(R.id.textViewName);
        textViewSport = findViewById(R.id.textViewSport);
        btnReturn = findViewById(R.id.buttonReturn);
    }

}

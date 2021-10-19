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
        btnReturn.setOnClickListener(this);

        String name = getIntent().getStringExtra("name");
        String label = textViewName.getText().toString();

        int idSport = getIntent().getIntExtra("sport", -100);

        textViewName.setText(label + " " + name);

        String sport = "No Sport!";
        switch (idSport) {
            case R.id.radioButtonSoccer: {
                sport = "Soccer.";
                break;
            }
            case R.id.radioButtonHandball: {
                sport = "Handball.";
                break;
            }
            case R.id.radioButtonHockey: {
                sport = "Hockey.";
                break;
            }
        }
        textViewSport.setText(textViewSport.getText().toString() +  " " + sport);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}

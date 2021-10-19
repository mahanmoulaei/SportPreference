package com.example.sportpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName;
    RadioGroup radioGroupSport;
    Button btnClear, btnNext, btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        editTextName = findViewById(R.id.editTextName);
        radioGroupSport = findViewById(R.id.radioGroupSport);
        btnClear = findViewById(R.id.buttonClear);
        btnClear.setOnClickListener(this);
        btnNext = findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(this);
        btnQuit = findViewById(R.id.buttonQuit);
        btnQuit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.buttonClear: {
                clear();
                break;
            }
            case R.id.buttonNext: {
                goToSecondActivity();
                break;
            }
            case R.id.buttonQuit: {
                quitApp();
                break;
            }
        }
    }

    private void goToSecondActivity() {
        String name = editTextName.getText().toString();
        int idSport = radioGroupSport.getCheckedRadioButtonId();
        //Log.d("message", String.valueOf(idSport));
        if (name.isEmpty()) {
            Toast.makeText(this, "Name Cannot Be Empty!", Toast.LENGTH_LONG).show();
        } else if (idSport == -1) {
            Toast.makeText(this, "You Need To Check 1 Sport!", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("sport", idSport);
            startActivity(intent);
        }
    }

    private void quitApp() {
        System.exit(0);
    }

    private void clear() {
        editTextName.setText(null);
        radioGroupSport.clearCheck();
    }
}
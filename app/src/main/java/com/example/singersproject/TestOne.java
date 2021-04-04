package com.example.singersproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
public class TestOne extends AppCompatActivity {


    String[] chanteurs = {"Eminem", "The weeknd", "Shayfeen", "Selena Gomez"};
    int[] snippets= new int[]{R.raw.eminem, R.raw.weeknd, R.raw.shayfeen, R.raw.selena};
    Random random = new Random();
    int rand = random.nextInt(4);

    static boolean result = false;


    Button jouerButton, validerButton, annulerButton;
    Spinner sp;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_one);

        jouerButton = findViewById(R.id.jouer);
        validerButton = findViewById(R.id.valider);
        annulerButton = findViewById(R.id.annuler);
        sp = findViewById(R.id.sp);
        tv = findViewById(R.id.tv);

        MediaPlayer media= MediaPlayer.create(getApplicationContext(), snippets[rand]);

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (getApplicationContext(), android.R.layout.simple_spinner_item, chanteurs);

        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == rand)
                    result = true;
                else
                    result = false;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        jouerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media.start();
            }
        });

        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result) {
                    Toast.makeText(getBaseContext(),"Correct, passons au suivant", Toast.LENGTH_SHORT).show();
                    media.stop();
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }else
                    Toast.makeText(getBaseContext(),"Ecoute attentivement et réesaye", Toast.LENGTH_SHORT).show();
            }
        });
    }
    

    public void annuler(View v){
        Intent i= new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
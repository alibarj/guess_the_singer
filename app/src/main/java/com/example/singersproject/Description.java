package com.example.singersproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Description extends AppCompatActivity {

    int[] img = new int[]{
            R.drawable.eminem,
            R.drawable.selena,
            R.drawable.shayfeen,
            R.drawable.weeknd
    };
    int[] snippets= new int[]{
            R.raw.eminem,
            R.raw.selena,
            R.raw.shayfeen,
            R.raw.weeknd
    };
    String[] descriptions= new String[]{
            "Eminem, souvent stylisé EMINƎM, de son vrai nom Marshall Bruce Mathers III, né le 17 octobre 19721 à Saint Joseph dans l'État du Missouri, est un rappeur américain, également producteur, acteur, compositeur, et fondateur de label. En plus de sa carrière solo, il fut aussi membre du groupe D12, dont il est le cofondateur, et compose le duo Bad Meets Evil avec Royce da 5'9\". Il a également fait partie, dans sa jeunesse, d'un groupe nommé Soul Intent, et a intégré temporairement le groupe Outsidaz dans la seconde moitié des années 19902.",
            "Selena Gomez, née le 22 juillet 1992 à Grand Prairie, au Texas, est une chanteuse, actrice et productrice américaine. Elle fait ses débuts de comédienne dans la série pour enfants Barney & Friends (2002-2004), puis se fait connaître du jeune public en interprétant le rôle d'Alex Russo dans la série humoristique de Disney Channel, Les Sorciers de Waverly Place (2007-2012).",
            "Shayfeen est un groupe de rap marocain crée par Chouaib Ribati (Shobee) et Abdessamad Lamriq (Small X) en 2006. n 2012, après une participation réussie à la caravane de Génération Mawazine, ils sortent leur premier mixtape nommé Energie. Il comprend 15 titres. Début 2016, le duo publie leur premier EP intitulé 07 (en référence à leur ville d'origine, Safi) et composé de 7 chansons.",
            "The Weeknd, de son vrai nom Abel Makkonen Tesfaye, né le 16 février 1990 à Toronto, au Canada, est un auteur-compositeur-interprète, musicien et producteur canadien. The Weeknd compte quatre albums classés numéro 1 (Beauty Behind the Madness en 2015, Starboy en 2016, My Dear Melancholy en 2018 et After Hours en 2020), et un album numéro 2 (Kiss Land en 2013) au Billboard 200"
    };

    TextView description;
    ImageView singerImage;
    Button butBack;
    FloatingActionButton butPLaySnippet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        int singerId = Integer.parseInt(getIntent().getStringExtra("singerIndex"));

        description = findViewById(R.id.description);
        description.setText(descriptions[singerId]);
        singerImage = findViewById(R.id.singerImage);
        singerImage.setImageResource(img[singerId]);
        butBack = findViewById(R.id.butBack);
        butPLaySnippet = findViewById(R.id.butPLaySnippet);

        MediaPlayer media= MediaPlayer.create(getApplicationContext(), snippets[singerId]);

        butPLaySnippet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media.start();
            }
        });

        butBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media.stop();
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

}
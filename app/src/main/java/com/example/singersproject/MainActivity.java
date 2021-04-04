package com.example.singersproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] chanteurs = new String[] {
            "Eminem",
            "Selene Gomez",
            "Shayfeen",
            "The weeknd"
    };
    String[] origines = new String[] {
            "USA",
            "Mexique",
            "Maroc",
            "Canada"
    };
    int[] img = new int[]{
            R.drawable.eminem,
            R.drawable.selena,
            R.drawable.shayfeen,
            R.drawable.weeknd
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<4;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", "Alias : " + chanteurs[i]);
            hm.put("txt2", "Origine : " + origines[i]);
            hm.put("flag", Integer.toString(img[i]) );

            aList.add(hm);
        }

        //Here we establish the cnx between the hashmap and the elements in layout
        // Keys used in Hashmap
        String[] from = { "flag", "txt", "txt2"}; //The data to fill templates with
        // Ids of views in listview_layout
        int[] to = { R.id.flag, R.id.txt, R.id.txt2};//The templates

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.layout_list, from, to);
        ListView listView = findViewById(R.id.lv);
        // Setting the adapter to the listView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(getApplicationContext(),Description.class);
                i.putExtra("singerIndex", String.valueOf(position));
                startActivity(i);
            }
        });

    }

    public void testeCompetance(View v){
        Intent i= new Intent(getApplicationContext(),TestOne.class);
        startActivity(i);
    }


}
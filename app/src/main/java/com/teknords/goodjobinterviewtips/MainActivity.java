package com.teknords.goodjobinterviewtips;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private GoogleApiClient client;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("ca-app-pub-1261846064716355/6859850624").build();
        mAdView.loadAd(adRequest);


        ListView listView = (ListView)findViewById(R.id.listView);

        final String[] data ={"How to Answer Human Resource Interview Questions",
        "How to Communicate Effectively in a Job Interview",
        "How to Go to an Interview",
        "How to have Good job interview",
        "How to Interview Someone",
        "How to Pass a Job Interview",
        "How to Perform Well in a Group Interview",
        "How to Prepare for a Job Interview",
        "How to Prepare For a Phone Interview ",
        "How to Prepare for Interview Questions Thoroughly",
        "How to Write Interview Questions"};

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.mytextview, data);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,Text.class);
                intent.putExtra("selectedDua",position);
                startActivity(intent);



            }
        });


    }
}

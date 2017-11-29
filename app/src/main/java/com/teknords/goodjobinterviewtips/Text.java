package com.teknords.goodjobinterviewtips;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Text extends AppCompatActivity {

    int nextImg=0;
    Dbhelper dbhelperobj;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("ca-app-pub-1261846064716355/7384241021").build();
        mAdView.loadAd(adRequest);



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1261846064716355/8860974225");
        AdRequest adRequestInter = new AdRequest.Builder().build();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mInterstitialAd.show();
            }
        });
        mInterstitialAd.loadAd(adRequestInter);


        Button btnshare = (Button)findViewById(R.id.btnshare);
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "AndroidSolved");
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });




        Button btnbaack = (Button)findViewById(R.id.btnback);
        btnbaack.rride
        publsetOnClickListener(new View.OnClickListener() {
            @Oveic void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Intent i = new Intent(Text.this, MainActivity.class);
                startActivity(i);
                /*mInterstitialAd = new InterstitialAd(getApplicationContext());
                mInterstitialAd.setAdUnitId("ca-app-pub-1261846064716355/2061221022");
                AdRequest adRequestInter = new AdRequest.Builder().build();
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        mInterstitialAd.show();
                    }
                });
                mInterstitialAd.loadAd(adRequestInter);*/
            }
        });






            dbhelperobj = new Dbhelper(this);
            dbhelperobj.createDatabse();
            final TextView description=(TextView)findViewById(R.id.details);
            final TextView descriptionArb=(TextView)findViewById(R.id.txttitile);



        description.setMovementMethod(new ScrollingMovementMethod());

            Intent i = getIntent();
             int slctdArg = i.getIntExtra("selectedDua", 0);//here 0 is default value


            final ArrayList<String> allTraficSings= dbhelperobj.getTotalSign(slctdArg);
           final ArrayList<String> engText= dbhelperobj.engText(slctdArg);
           final ArrayList<String> arbText= dbhelperobj.arbText(slctdArg);

            String alTotSign=allTraficSings.get(nextImg);
            String low_case=alTotSign.toLowerCase();
            low_case=low_case.replaceAll(".jpg","");

            low_case="drawable/"+low_case;

            final ImageView img = (ImageView) findViewById(R.id.img);
            int imageResource = getResources().getIdentifier(low_case, null, getPackageName());
            Drawable image = getResources().getDrawable(imageResource);
            img.setImageDrawable(image);
            description.setText(engText.get(nextImg));
            descriptionArb.setText(arbText.get(nextImg));


                Button btnnext = (Button)findViewById(R.id.btnnext);

            btnnext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ++nextImg;
                    if(nextImg==allTraficSings.size()){
                        nextImg=allTraficSings.size()-1;
                        Toast.makeText(getApplicationContext(),"Click Previous", Toast.LENGTH_SHORT).show();

                    }




                    String alTotSign=allTraficSings.get(nextImg);
                    String low_case=alTotSign.toLowerCase();
                    low_case=low_case.replaceAll(".jpg","");
                    low_case="drawable/"+low_case;

                    int imageResource = getResources().getIdentifier(low_case, null, getPackageName());
                    Drawable image = getResources().getDrawable(imageResource);
                    img.setImageDrawable(image);


                    description.setText(engText.get(nextImg));
                   descriptionArb.setText(arbText.get(nextImg));


                }
            });


        Button btnprvs = (Button)findViewById(R.id.btnprvs);



            btnprvs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nextImg--;
                    if(nextImg<=0){
                        nextImg=1;
                        Toast.makeText(getApplicationContext(),"Click next", Toast.LENGTH_SHORT).show();

                    }else {


                        String alTotSign=allTraficSings.get(nextImg);
                        String low_case=alTotSign.toLowerCase();
                        low_case=low_case.replaceAll(".jpg","");
                        low_case="drawable/"+low_case;


                        int imageResource = getResources().getIdentifier(low_case, null, getPackageName());
                        Drawable image = getResources().getDrawable(imageResource);
                        img.setImageDrawable(image);
                        description.setText(engText.get(nextImg));
                       descriptionArb.setText(arbText.get(nextImg));

                    }

                }
            });







        }
        @Override
        public void onBackPressed()
        {
            super.onBackPressed();  // optional depending on your needs
           /* showInterstitial();*/
        }

        /*private void showInterstitial() {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        }*/


    }


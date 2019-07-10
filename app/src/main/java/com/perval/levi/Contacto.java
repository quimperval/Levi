package com.perval.levi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Contacto extends AppCompatActivity {


    private ImageView mImageView;
    private AdView mAdViewCont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Cont);
        setSupportActionBar(toolbar);


        mImageView = (ImageView) findViewById(R.id.imageperval);

        mImageView.setOnClickListener(new ClickenImagen());


        MobileAds.initialize(this,getResources().getString(R.string.adMobId));

        mAdViewCont = findViewById(R.id.adViewCont);

        AdRequest adRequestHelp = new AdRequest.Builder().build();
        mAdViewCont.loadAd(adRequestHelp);


    }



    public void GoToPerval (View view){
        goToUrl("http://www.per-val.com");
    }

    private void goToUrl (String url){
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


    public void SendEmail(View view){

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","hikra@per-val.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Suggestions and comments");
        emailIntent.putExtra(Intent.EXTRA_TEXT, " ");
        startActivity(Intent.createChooser(emailIntent, " "));
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.top_in, R.anim.top_out);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    class ClickenImagen implements View.OnClickListener{

        @Override
        public void onClick(View v){

            goToUrl("http://www.per-val.com");
        }
    }

}

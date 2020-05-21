package com.perval.levi;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class Contacto extends AppCompatActivity {


    private Button githubButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Cont);
        setSupportActionBar(toolbar);


        githubButton = (Button) findViewById(R.id.buttonGitHub);

        githubButton.setOnClickListener(new ClickenImagen());

    }

    private void goToUrl (String url){
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


    public void SendEmail(View view){

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","joaquinperezvalera@gmail.com", null));
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

            goToUrl("https://github.com/quimperval/Levi");
        }
    }

}

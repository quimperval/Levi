package com.perval.levi;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.perval.levi.ayuda.EulaActivity;
import com.perval.levi.ayuda.Help;

public class MainActivity extends AppCompatActivity {
     Toolbar toolbar;
     TabLayout tabLayout;
     ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding toobar and setting it support
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.ayuda:
                Intent helpIntent = new Intent(MainActivity.this, Help.class);
                startActivity(helpIntent);
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                return true;
            case R.id.contacto:
                Intent Cont_Intent = new Intent(MainActivity.this, Contacto.class );
                startActivity(Cont_Intent);
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                return true;
            case R.id.licencia:
                Intent Eula_Intent = new Intent(MainActivity.this, EulaActivity.class );
                startActivity(Eula_Intent);
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void GotoPresion(View view){

        Intent presionIntent = new Intent(this, FlujoAPresion.class);
        startActivity(presionIntent);

        //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void GotoCanal(View view){

        Intent canalIntent = new Intent(this, FlujoACanal.class);
        startActivity(canalIntent);
        //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }



}

package com.perval.levi;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class FlujoACanal extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    Toolbar toolbarCanal;
    TabLayout tabLayout;
    ViewPager viewPager;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.postponeEnterTransition(this);
        setContentView(R.layout.activity_flujo_acanal);
        //finding toobar and setting it support
        Toolbar toolbarCanal = (Toolbar) findViewById(R.id.Tb_flujocanal);
        setSupportActionBar(toolbarCanal);


        //find TabLayout and set tabs
        tabLayout = (TabLayout) findViewById(R.id.TLay_flujocanal);

        //add tabs
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Tit_seccion_Circular));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Tit_seccion_Rectangular));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Tit_seccion_trapecial));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Tit_seccion_portal));


        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        //find view pager
        viewPager = (ViewPager) findViewById(R.id.VPager_flujocanal);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        //tablayout listener for selected
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabLayout.setScrollPosition(position,0, true);
                tabLayout.setSelected(true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        MobileAds.initialize(this,getResources().getString(R.string.adMobId));

        mAdView = findViewById(R.id.adView_flujocanal);
        //mAdView.setAdSize(AdSize.BANNER);
        //mAdView.setAdUnitId(getResources().getString(R.string.UnitId));
        AdRequest adRequest = new AdRequest.Builder().build();
        //AdRequest adRequest = new AdRequest().Builder.addTestDevice("").build();
       // AdRequest adRequest = new AdRequest.Builder()
         //       .addTestDevice("4C930254D43B6F8508F9DFD710981A80")  // An example device ID
           //     .build();
        mAdView.loadAd(adRequest);



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
                Intent helpIntent = new Intent(this, Help.class);
                startActivity(helpIntent);
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);

                return true;
            case R.id.contacto:
                Intent Cont_Intent = new Intent(this, Contacto.class );
                startActivity(Cont_Intent);
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}

package com.perval.levi;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.perval.levi.ayuda.EulaActivity;
import com.perval.levi.ayuda.Help;

public class FlujoACanal extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    Toolbar toolbarCanal;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

            case R.id.licencia:
                Intent Eula_Intent = new Intent(this, EulaActivity.class );
                startActivity(Eula_Intent);
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

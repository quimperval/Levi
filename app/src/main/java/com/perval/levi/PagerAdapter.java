package com.perval.levi;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.perval.levi.fragments.FragCanalCircular;
import com.perval.levi.fragments.FragCanalPortal;
import com.perval.levi.fragments.FragCanalRectangular;
import com.perval.levi.fragments.FragCanalTrapecial;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumofTabs;

    public PagerAdapter(FragmentManager fm, int NumofTabs){
        super(fm);
        this.mNumofTabs= NumofTabs;

    }

    @Override
    public Fragment getItem(int position){

        switch (position){
            case 0:
                FragCanalCircular tab0 = new FragCanalCircular();
                return tab0;
            case 1:
                FragCanalRectangular tab1 = new FragCanalRectangular();
                return tab1;

            case 2:
                FragCanalTrapecial tab2 = new FragCanalTrapecial();
                return tab2;
            case 3:
                FragCanalPortal tab3 = new FragCanalPortal();
                return tab3;
            default:
                return null;

        }

    }

    @Override
    public int getCount(){
        return mNumofTabs;
    }
}

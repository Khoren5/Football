package com.example.dell.football;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

/**
 * Created by DELL on 24.02.2018.
 */

public class ARARATADAPTER extends FragmentPagerAdapter{
    public ARARATADAPTER(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
switch (position){
    case 0:return new ararat732();
    case 1:return new araraat733();
}
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

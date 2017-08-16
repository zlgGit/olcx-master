package com.ol.olcx.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by GW00070468 on 2017/8/16.
 */

public class MapPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public MapPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.mFragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}

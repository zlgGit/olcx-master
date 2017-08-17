package com.ol.olcx.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps.AMap;
import com.amap.api.maps.TextureMapView;
import com.ol.olcx.R;
import com.ol.olcx.Views.ScrollViewPager;
import com.ol.olcx.adapters.MapPagerAdapter;

import java.util.ArrayList;

/**
 *
 */
    public class MapTFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    private TextureMapView mMapView;
    private AMap mMap;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ScrollViewPager mContainer;


    public static MapTFragment newInstance(Bundle args) {

        MapTFragment fragment = new MapTFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static MapTFragment newInstance() {

        MapTFragment fragment = new MapTFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_map, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mContainer = (ScrollViewPager) view.findViewById(R.id.container);

        ArrayList<Fragment> fragments = new ArrayList<>();
        RentCarFragment rentCarFragment = new RentCarFragment();
        PriviateCarFragment priviateCarFragment = new PriviateCarFragment();

        fragments.add(rentCarFragment);
        fragments.add(priviateCarFragment);
        FragmentManager childFragmentManager = getChildFragmentManager();

        mContainer.setAdapter(new MapPagerAdapter(childFragmentManager, fragments));
//        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
//
//
//        MapAdapter mapAdapter=new MapAdapter(getActivity());
//        mViewPager.setAdapter(mapAdapter);
        mTabLayout.addTab(mTabLayout.newTab().setText("网约车"));
        mTabLayout.addTab(mTabLayout.newTab().setText("分时租赁"));
        mTabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab.getText().equals("网约车")) {
            mContainer.setCurrentItem(0);
        }else {
            mContainer.setCurrentItem(1,true);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


}

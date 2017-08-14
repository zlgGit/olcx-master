package com.ol.olcx.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.ol.olcx.R;
import com.ol.olcx.adapters.MapAdapter;

/**
 *
 */
    public class MapTFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    private TextureMapView mMapView;
    private AMap mMap;
    private FrameLayout mTitleCenter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FrameLayout mContainer;

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
//        mMapView = (TextureMapView) getView().findViewById(R.id.mapview);
//        if (mMapView != null) {
//            mMapView.onCreate(savedInstanceState);
//            mMap = mMapView.getMap();
//            if (getCameraPosition() == null) {
//                aMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(getTarget(), 10, 0, 0)));
//            }else {
//                aMap.moveCamera(CameraUpdateFactory.newCameraPosition(getCameraPosition()));
//            }
//        }
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

        mTitleCenter = (FrameLayout) view.findViewById(R.id.base_title_center);

        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mContainer = (FrameLayout) view.findViewById(R.id.container);
//        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
//
//
//        MapAdapter mapAdapter=new MapAdapter(getActivity());
//        mViewPager.setAdapter(mapAdapter);
        mTabLayout.addTab(mTabLayout.newTab().setText("网约车"));
        mTabLayout.addTab(mTabLayout.newTab().setText("专车"));
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
//        if (tab.getText().equals("网约车")) {
//            mViewPager.setCurrentItem(0);
//        }else {
//            mViewPager.setCurrentItem(1);
//        }

        FragmentManager childFragmentManager = getChildFragmentManager();
        MapTFragmentCo mTC=new MapTFragmentCo();
        childFragmentManager.beginTransaction().add(R.id.container,mTC,"mTc").commit();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


}

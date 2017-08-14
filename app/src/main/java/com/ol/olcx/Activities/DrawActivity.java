package com.ol.olcx.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.ol.olcx.R;
import com.ol.olcx.fragments.MapTFragment;
import com.ol.olcx.fragments.MapTFragmentCo;

public class DrawActivity extends AppCompatActivity {

    private FrameLayout mMapContainer;
    private MapTFragment mMapFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        initView();
    }

    private void initView() {
        mMapContainer = (FrameLayout) findViewById(R.id.container);
        mMapFragment = MapTFragment.newInstance();

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.container,mMapFragment,"mMapFragment");
        transaction.commitAllowingStateLoss();
//        MapTFragmentCo mTC=new MapTFragmentCo();
//        getSupportFragmentManager().beginTransaction().add(R.id.container,mTC,"mTc");
    }
}

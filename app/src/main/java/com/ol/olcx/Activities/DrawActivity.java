package com.ol.olcx.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ol.olcx.R;
import com.ol.olcx.fragments.MapTFragment;

public class DrawActivity extends AppCompatActivity {

    private FrameLayout mMapContainer;
    private MapTFragment mMapFragment;
    private FragmentManager mFragmentManager;
    private ImageView mIv_l;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        initView();
    }

    private void initView() {

        mIv_l = (ImageView) findViewById(R.id.base_image_left);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawlayout);
        LinearLayout relativeLayout = (LinearLayout) findViewById(R.id.draw_right);
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return true;
            }
        });

        mIv_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        mMapContainer = (FrameLayout) findViewById(R.id.left_drawer);
        mMapFragment = MapTFragment.newInstance();

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.left_drawer,mMapFragment,"mMapFragment");
        transaction.commitAllowingStateLoss();
//        MapTFragmentCo mTC=new MapTFragmentCo();
//        getSupportFragmentManager().beginTransaction().add(R.id.container,mTC,"mTc");
    }
}

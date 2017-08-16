package com.ol.olcx.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.amap.api.col.n3.lh;
import com.ol.olcx.R;
import com.ol.olcx.fragments.MapTFragment;

;

public class DrawActivity2 extends AppCompatActivity {


    private ImageView mIv_l;
    private DrawerLayout mDrawerLayout;
    private FrameLayout mTitleCenter;
    private Handler mHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw2);
        initView();


    }
    private void initView() {

        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawlayout);
//        mDrawerLayout.openDrawer(GravityCompat.START);

            mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                    finish();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        },300);

    }
}

package com.ol.olcx.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ol.olcx.R;

;import butterknife.BindView;
import butterknife.ButterKnife;

public class DrawActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.navigation)
    NavigationView mNavigation;
    private ImageView mIv_l;
    private DrawerLayout mDrawerLayout;
    private FrameLayout mTitleCenter;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw2);
        ButterKnife.bind(this);
        initView();


    }

    private void initView() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawlayout);
//        mDrawerLayout.openDrawer(GravityCompat.START);
        mNavigation.setNavigationItemSelectedListener(this);
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
        }, 300);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.wallet:
                break;
            case R.id.order_info:
                break;
            case R.id.user_score:
                break;
            case R.id.use_info:
                break;
            case R.id.violation_record:
                break;
            case R.id.setting:
                break;
            case R.id.me_listico_help:
                break;
            case R.id.me_feedback:
                break;
        }

        return true;
    }
}

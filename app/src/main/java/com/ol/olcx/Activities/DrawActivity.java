package com.ol.olcx.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
;
import com.ol.olcx.CcHttp.CcCallBack;
import com.ol.olcx.HttpInterfaces.CarStationHttp;
import com.ol.olcx.HttpInterfaces.LoginHttp;
import com.ol.olcx.R;
import com.ol.olcx.beans.BaseBean;
import com.ol.olcx.beans.CarStationBean;
import com.ol.olcx.beans.StationInfoBean;
import com.ol.olcx.fragments.MapTFragment;

import java.util.List;

public class DrawActivity extends AppCompatActivity {

    private FrameLayout mMapContainer;
    private MapTFragment mMapFragment;
    private FragmentManager mFragmentManager;
    private ImageView mIv_l;

    private FrameLayout mTitleCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        initView();

    }
    private void initView() {

        mIv_l = (ImageView) findViewById(R.id.base_image_left);
        mTitleCenter = (FrameLayout) findViewById(R.id.base_title_center);



        mIv_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mDrawerLayout.openDrawer(GravityCompat.START);
                Intent intent = new Intent(DrawActivity.this,DrawActivity2.class);
                startActivity(intent);
            }
        });

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

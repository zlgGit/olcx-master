package com.ol.olcx.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ol.olcx.R;

import com.ol.olcx.fragments.MapTFragment;

public class DrawActivity extends AppCompatActivity {

    private FrameLayout mMapContainer;
    private MapTFragment mMapFragment;
    private FragmentManager mFragmentManager;
    private ImageView mIv_l;

    private FrameLayout mTitleCenter;
    public static final String [] permissions= {Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};
    public static final int LOCATION_RQE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        initView();
        permissin();

    }

    private void permissin() {

        if (checkSelfPermissions(this,permissions)) {

        }else {
            ActivityCompat.requestPermissions(this,permissions,LOCATION_RQE);

        }
    }

    private boolean checkSelfPermissions(Activity activity, String[] permissions) {

        for (int i = 0; i < permissions.length; i++) {

            if (ContextCompat.checkSelfPermission(activity,permissions[i])== PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }


        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkSelfPermissions(this,permissions)) {
            Toast.makeText(this,"permssion is ok",Toast.LENGTH_LONG).show();
        }

    }

    private void initView() {

        mIv_l = (ImageView) findViewById(R.id.base_image_left);
        mTitleCenter = (FrameLayout) findViewById(R.id.base_title_center);
        View inflate = LayoutInflater.from(this).inflate(R.layout.title_center, null);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity=Gravity.CENTER;
        inflate.setLayoutParams(params);
        TextView city = (TextView) inflate.findViewById(R.id.city);
        mTitleCenter.addView(inflate);



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
    }
}

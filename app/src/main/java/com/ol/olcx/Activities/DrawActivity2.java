package com.ol.olcx.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ol.olcx.CcLog;
import com.ol.olcx.R;
import com.ol.olcx.util.DensityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

;

public class DrawActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private final String TAG = DrawActivity2.this.getClass().getSimpleName();
    @BindView(R.id.navigation)
    NavigationView mNavigation;
    @BindView(R.id.collasping)
    CollapsingToolbarLayout mCollasping;
    @BindView(R.id.toobar)
    Toolbar Toobar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.title)
    RelativeLayout mTitle;
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
        mCollasping.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        mAppbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout mToobar, int verticalOffset) {
                int standerApha = DensityUtil.dip2px(DrawActivity2.this, 50);
                int maxPx = DensityUtil.dip2px(DrawActivity2.this, 260);
                float stand = Math.abs((float) (verticalOffset * 1.0 / standerApha));
                CcLog.i("---maxPx",""+maxPx);
                CcLog.i("---stand",""+stand);
                CcLog.i("---standerApha",""+standerApha);
                CcLog.i("---verticalOffset",""+verticalOffset);
                if (stand < 1) {
                    mTitle.setAlpha(1 - stand);
                } else {

                    double v = (maxPx - verticalOffset) * 1.0 / (maxPx - standerApha);

                    Toobar.setAlpha(Math.abs((float) v));
                }

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
        CcLog.i(TAG, "item" + item.getItemId());
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.wallet:
                intent = new Intent(this, WalletActivity.class);

                break;
            case R.id.order_info:
                intent = new Intent(this, OrderInfoActivity.class);
                break;
            case R.id.user_score:
                break;
            case R.id.use_info:
                intent = new Intent(this, ProfileInfoActivity.class);
                break;
            case R.id.violation_record:
                intent = new Intent(this, IllegalActivity.class);
                break;
            case R.id.setting:
                intent = new Intent(this, SettingActivity.class);
                break;
            case R.id.me_listico_help:
                break;
            case R.id.me_feedback:
                break;
        }
        if (intent != null) startActivity(intent);
        return true;
    }
}

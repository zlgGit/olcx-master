package com.ol.olcx.Activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ol.olcx.CcLog;
import com.ol.olcx.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileInfoActivity extends AppCompatActivity {

    @BindView(R.id.profile_appbar)
    AppBarLayout mProfileAppbar;
    @BindView(R.id.profile_toobar)
    Toolbar mProfileToobar;
    @BindView(R.id.profile_refresh)
    SmartRefreshLayout mProfileRefresh;
    @BindView(R.id.bg_img)
    ImageView mBgImg;

    @BindView(R.id.profile_item5)
    LinearLayout mProfileItem5;
    @BindView(R.id.profile_back)
    ImageView mProfileBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);
        ButterKnife.bind(this);
        mProfileRefresh.setHeaderMaxDragRate((float) 1.3);
        mProfileAppbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float alpha = (float) (verticalOffset * 1.0 / 250);
                mProfileToobar.setAlpha(Math.abs(alpha));
                CcLog.i("--verticalOffset", "" + verticalOffset);
            }
        });
        mProfileRefresh.setOnMultiPurposeListener(new OnMultiPurposeListener() {
            @Override
            public void onHeaderPulling(RefreshHeader header, float percent, int offset, int headerHeight, int extendHeight) {

                float scaley = (float) (offset * 1.0 / headerHeight);
                float v = scaley / 8;
                mBgImg.setScaleY(1 + v);
                mBgImg.setScaleX(1 + v);

                CcLog.i("--onHeaderPulling-offset", "" + offset);
                CcLog.i("--onHeaderPulling-headerHeight", "" + headerHeight);
            }

            @Override
            public void onHeaderReleasing(RefreshHeader header, float percent, int offset, int headerHeight, int extendHeight) {
                float scaley = (float) (offset * 1.0 / headerHeight);
                float v = scaley / 8;
                mBgImg.setScaleY(1 + v);
                mBgImg.setScaleX(1 + v);
                CcLog.i("--onHeaderReleasing-offset", "" + offset);
                CcLog.i("--onHeaderReleasing-headerHeight", "" + headerHeight);
            }

            @Override
            public void onHeaderStartAnimator(RefreshHeader header, int headerHeight, int extendHeight) {

            }

            @Override
            public void onHeaderFinish(RefreshHeader header, boolean success) {

            }

            @Override
            public void onFooterPulling(RefreshFooter footer, float percent, int offset, int footerHeight, int extendHeight) {

            }

            @Override
            public void onFooterReleasing(RefreshFooter footer, float percent, int offset, int footerHeight, int extendHeight) {

            }

            @Override
            public void onFooterStartAnimator(RefreshFooter footer, int footerHeight, int extendHeight) {

            }

            @Override
            public void onFooterFinish(RefreshFooter footer, boolean success) {

            }

            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

            }

            @Override
            public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {

            }
        });
    }


    @OnClick(R.id.profile_back)
    public void onViewClicked() {
        finish();
    }


}

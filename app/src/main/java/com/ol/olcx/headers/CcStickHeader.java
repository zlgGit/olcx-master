package com.ol.olcx.headers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ol.olcx.CcLog;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/**
 * Created by GW00070468 on 2017/8/21.
 */

public class CcStickHeader extends View implements RefreshHeader {
    private static final String TAG = CcStickHeader.class.getSimpleName();
    private boolean mEndOfRefreshing;
    private float mPercent;
    private int mHeaderHeight;

    public CcStickHeader(Context context) {
        super(context);
        initView(context, null);
    }



    public CcStickHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public CcStickHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        setBackgroundColor(0xff11bbff);
    }

    @Override
    public void onPullingDown(float percent, int offset, int headerHeight, int extendHeight) {
        mEndOfRefreshing = false;
        mPercent = 1f * offset / headerHeight;
        mHeaderHeight = headerHeight;
        CcLog.i(TAG,"--onPullingDown   mPercent "+mPercent+"/n"+"mHeaderHeight "+mHeaderHeight);
    }

    @Override
    public void onReleasing(float percent, int offset, int headerHeight, int extendHeight) {
        mPercent = 1f * offset / headerHeight;
        mHeaderHeight = headerHeight;
        CcLog.i(TAG,"--onReleasing     mPercent "+mPercent+"/n"+"mHeaderHeight "+mHeaderHeight);
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.FixedFront;
    }

    @Override
    public void setPrimaryColors(int... colors) {
        setBackgroundColor(colors[0]);
    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int height, int extendHeight) {

    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        return 0;
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {

    }
}

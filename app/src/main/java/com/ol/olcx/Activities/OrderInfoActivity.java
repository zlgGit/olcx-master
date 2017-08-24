package com.ol.olcx.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.ol.olcx.CcLog;
import com.ol.olcx.R;
import com.ol.olcx.adapters.OrderPagerAdapter;
import com.ol.olcx.fragments.OrderZCFragment;
import com.ol.olcx.fragments.OrderZJFragment;
import com.ol.olcx.fragments.PageFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnPageChange;

public class OrderInfoActivity extends AppCompatActivity {


    @BindView(R.id.bace)
    ImageView mBace;
    @BindView(R.id.order_table)
    TabLayout mOrderTable;
    @BindView(R.id.order_viewpager)
    ViewPager mOrderViewpager;


    public static final String ZJOD="自驾订单";
    public static final String ZCOD="专车订单";
    private ArrayList<PageFragment> mFragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mOrderTable.addTab(mOrderTable.newTab().setText(ZJOD));
        mOrderTable.addTab(mOrderTable.newTab().setText(ZCOD));
        mOrderTable.setupWithViewPager(mOrderViewpager);
        OrderZCFragment orderZCFragment = OrderZCFragment.newInstance();
        OrderZJFragment orderZJFragment = OrderZJFragment.newInstance();
        mFragments = new ArrayList<>();
        mFragments.add(orderZCFragment);
        mFragments.add(orderZJFragment);
        mOrderViewpager.setAdapter(new OrderPagerAdapter(getSupportFragmentManager(),mFragments));
    }

    @OnClick({R.id.bace})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bace:
                finish();
                break;
        }
    }
    @OnPageChange(value = R.id.order_viewpager,callback = OnPageChange.Callback.PAGE_SELECTED)
    public void onPageSelected(int position) {
        CcLog.i("---onPageSelected",""+position);
    }

}

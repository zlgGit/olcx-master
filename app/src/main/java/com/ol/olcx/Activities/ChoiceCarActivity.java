package com.ol.olcx.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.ol.olcx.CcConstant;
import com.ol.olcx.MvpViews.ChoiceCarView;
import com.ol.olcx.R;
import com.ol.olcx.adapters.CarListAdapter;
import com.ol.olcx.beans.CarBean;
import com.ol.olcx.presenters.ChoiceCarPresenter;
import com.scwang.smartrefresh.header.FlyRefreshHeader;
import com.scwang.smartrefresh.header.flyrefresh.FlyView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChoiceCarActivity extends BaseActivity implements ChoiceCarView<List<CarBean>> {

    @BindView(R.id.car_recyclerview)
    RecyclerView mCarRecyclerview;
    @BindView(R.id.smartResfresh)
    SmartRefreshLayout mSmartResfresh;
    private ChoiceCarPresenter mChoiceCarPresenter;
    private int mStationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_choice_car);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mStationId = intent.getIntExtra(CcConstant.STATIONID, -1);
        mChoiceCarPresenter = new ChoiceCarPresenter(this);
//        RefreshHeader refreshHeader = mSmartResfresh.getRefreshHeader();
//        ((FlyRefreshHeader) refreshHeader).setUpFlyView(new FlyView(this));
        mSmartResfresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mChoiceCarPresenter.getStationCar(mStationId);

            }
        });

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected String initTitle() {
        return "车辆信息";
    }





    @Override
    public void setRecyclerViewDate(List<CarBean> carBeen) {
        mCarRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        CarListAdapter carListAdapter = new CarListAdapter(this, carBeen);
        mCarRecyclerview.setAdapter(carListAdapter);
      ;
    }

    @Override
    protected void imageLeftClick() {
        super.imageLeftClick();
        finish();
    }

    @Override
    public void onFailed(String error) {
        mSmartResfresh.finishRefresh(false);
    }

    @Override
    public void onSuccess() {
        mSmartResfresh.finishRefresh(true);
    }

    @Override
    public void preLoading() {

    }
}

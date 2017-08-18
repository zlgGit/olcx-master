package com.ol.olcx.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.ol.olcx.CcConstant;
import com.ol.olcx.R;
import com.ol.olcx.adapters.CarListAdapter;
import com.ol.olcx.beans.CarBean;
import com.ol.olcx.MvpViews.ChoiceCarView;
import com.ol.olcx.presenters.ChoiceCarPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChoiceCarActivity extends BaseActivity implements ChoiceCarView<List<CarBean>> {

    @BindView(R.id.car_recyclerview)
    RecyclerView mCarRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        int stationId = intent.getIntExtra(CcConstant.STATIONID, -1);
        ChoiceCarPresenter choiceCarPresenter = new ChoiceCarPresenter(this);
        choiceCarPresenter.getStationCar(stationId);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected View setBaseContentView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_choice_car,null);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void setRecyclerViewDate(List<CarBean> carBeen) {
        mCarRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        CarListAdapter carListAdapter = new CarListAdapter(this, carBeen);
        mCarRecyclerview.setAdapter(carListAdapter);
    }
}

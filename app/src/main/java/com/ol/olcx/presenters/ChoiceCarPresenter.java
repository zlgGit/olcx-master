package com.ol.olcx.presenters;

import com.ol.olcx.CcHttp.CcCallBack;
import com.ol.olcx.HttpInterfaces.ChoiceCarHttp;
import com.ol.olcx.Respnses.CarResponse;
import com.ol.olcx.beans.CarBean;
import com.ol.olcx.MvpViews.ChoiceCarView;

import java.util.List;

/**
 * Created by GW00070468 on 2017/8/18.
 */

public class ChoiceCarPresenter {


    private ChoiceCarView<List<CarBean>> mChoiceCarView;

    public ChoiceCarPresenter(ChoiceCarView choiceCarView) {

        mChoiceCarView = choiceCarView;
    }

    public void getStationCar(int stationid) {
        mChoiceCarView.showLoading();
        ChoiceCarHttp choiceCarHttp = new ChoiceCarHttp();
        choiceCarHttp.getStationCar(stationid).exucute(new CcCallBack<CarResponse>() {
            @Override
            public void onFailure(String error) {
                mChoiceCarView.dismissLoading();
            }

            @Override
            public void onSuccess(CarResponse carResponse) {

                mChoiceCarView.dismissLoading();
                if (carResponse.code==0) {
                    List<CarBean> data = carResponse.data;
                    mChoiceCarView.setRecyclerViewDate(data);

                }
            }
        });
    }
}

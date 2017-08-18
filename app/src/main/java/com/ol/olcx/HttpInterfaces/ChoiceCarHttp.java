package com.ol.olcx.HttpInterfaces;

import com.ol.olcx.CcConstant;
import com.ol.olcx.CcHttp.CcHttp;
import com.ol.olcx.Respnses.CarResponse;

/**
 * Created by GW00070468 on 2017/8/18.
 */

public class ChoiceCarHttp extends CcHttp<CarResponse>  {

    public static final String GET_CAR_LIST_URL= CcConstant.BASE_URL+"/car/getByStationId";

    public ChoiceCarHttp getStationCar(int stationId) {

        get().url(GET_CAR_LIST_URL)
                .addParams("stationId",""+1);
                return this;
    }
}

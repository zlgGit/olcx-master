package com.ol.olcx.HttpInterfaces;

import com.ol.olcx.CcConstant;
import com.ol.olcx.CcHttp.CcHttp;
import com.ol.olcx.Respnses.CarResponse;

/**
 * Created by GW00070468 on 2017/8/18.
 */

public class StationByDisHttp extends CcHttp<CarResponse>  {

    public static final String GET_CAR_LIST_URL= CcConstant.BASE_URL+"/station/getByDistance";

    public StationByDisHttp getStationCar(int cityCode, String x, String y) {

        get().url(GET_CAR_LIST_URL)
                .addParams("cityCode",cityCode+"")
                .addParams("x",x)
                .addParams("y",y);
                return this;
    }
}

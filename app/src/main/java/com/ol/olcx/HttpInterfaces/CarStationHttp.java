package com.ol.olcx.HttpInterfaces;

import com.ol.olcx.CcConstant;
import com.ol.olcx.CcHttp.CcHttp;
import com.ol.olcx.beans.CarStationBean;

/**
 * Created by GW00070468 on 2017/8/15.
 */

public class CarStationHttp extends CcHttp<CarStationBean> {

    public  final String STATION_URL= CcConstant.BASE_URL+"/station/getAll";
    public CarStationHttp getAllCarStaion()
    {
       get().url(STATION_URL);
        return this;
    }
}

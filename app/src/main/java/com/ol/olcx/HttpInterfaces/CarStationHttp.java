package com.ol.olcx.HttpInterfaces;

import com.ol.olcx.CcConstant;
import com.ol.olcx.CcHttp.CcHttp;
import com.ol.olcx.Respnses.CarResponse;
import com.ol.olcx.beans.CarStationBean;

/**
 * Created by GW00070468 on 2017/8/15.
 */

public class CarStationHttp extends CcHttp<CarResponse> {

    public  final String URL= CcConstant.BASE_URL+"/station/getByDistance";
    public CarStationHttp getCarInfo(int cityCode, double x, double y)

    {
       get().url(URL).addParams("cityCode",cityCode+"")
               .addParams("x",x+"").addParams("y",y+"");
        return this;
    }
}

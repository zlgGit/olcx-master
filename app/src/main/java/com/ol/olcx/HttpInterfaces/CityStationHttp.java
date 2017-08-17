package com.ol.olcx.HttpInterfaces;

import com.ol.olcx.CcConstant;
import com.ol.olcx.CcHttp.CcHttp;
import com.ol.olcx.beans.StationResponse;


/**
 * Created by gw00070468 on 2017/8/17.
 */

public class CityStationHttp extends CcHttp<StationResponse> {

    public  final String CITY_STATION_URL= CcConstant.BASE_URL+"/station/getByCity";
    public CityStationHttp getCityCarStaion(String cityCode)
    {
        get().url(CITY_STATION_URL).addParams("cityCode",cityCode);
        return this;
    }
}

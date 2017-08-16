package com.ol.olcx.beans;

import java.util.List;

/**
 * Created by GW00070468 on 2017/8/15.
 */

public class CarStationBean extends BaseBean {


    private List<StationInfoBean> data;

    public List<StationInfoBean> getData() {
        return data;
    }

    public void setData(List<StationInfoBean> data) {
        this.data = data;
    }

}

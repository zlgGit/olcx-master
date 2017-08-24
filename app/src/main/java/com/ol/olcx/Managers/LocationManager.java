package com.ol.olcx.Managers;

import android.content.Context;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.ol.olcx.SensorEventHelper;

/**
 * Created by gw00070468 on 2017/8/22.
 */

public class LocationManager {
    public static LocationManager instanse;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    public AMapLocationClient mlocationClient = null;


    public void init(Context context) {
        mlocationClient = new AMapLocationClient(context);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
//        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(100);

        //获取一次定位结果：
        //该方法默认为false。
        mLocationOption.setOnceLocation(true);

        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        mlocationClient.setLocationOption(mLocationOption);
    }

    private LocationManager() {

    }

    private static class LocationHolder {
        private final static LocationManager instance = new LocationManager();
    }

    public static LocationManager getInstanse() {
        return LocationHolder.instance;
    }

    public AMapLocationListener mAMapLocationListener;

    public void setAMapLocationListener(AMapLocationListener AMapLocationListener) {
        mAMapLocationListener = AMapLocationListener;
        mlocationClient.setLocationListener(mAMapLocationListener);
    }

    public void start() {
        mlocationClient.startLocation();
    }

    public void stop() {
        mlocationClient.stopLocation();
    }
}

package com.ol.olcx;

import android.app.Application;
import android.support.multidex.MultiDex;

/**
 * Created by GW00070468 on 2017/8/7.
 */

public class OlApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}

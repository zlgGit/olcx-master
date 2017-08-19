package com.ol.olcx.MvpViews;

/**
 * Created by GW00070468 on 2017/8/18.
 */

public interface BaseView {
    void onFailed(String error);
    void onSuccess();
    void preLoading();

}

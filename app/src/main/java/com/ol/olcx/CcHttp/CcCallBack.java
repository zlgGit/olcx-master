package com.ol.olcx.CcHttp;

/**
 * Created by GW00070468 on 2017/8/14.
 */

public interface CcCallBack<T>{
    void onFailure(String error);
    void onSuccess(T t);
}

package com.ol.olcx.CcHttp;

/**
 * Created by GW00070468 on 2017/8/15.
 */

interface ParamsTask<V> {

    V url(String url);
    V addParams(String key,String value);
    V addHeader(String key,String value);
    V tag(String tag);
}

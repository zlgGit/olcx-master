package com.ol.olcx.CcHttp;

/**
 * Created by GW00070468 on 2017/8/15.
 */

 interface HttpTask<T> {

//     url(String url);
//     addParams(String key,String value);
//     addHeader(String key,String value);
//     tag(String tag);
    void exucute(CcCallBack<T> ccCallBack);
    void add(CcRequest ccRequest);
    void add(Class cls);


}

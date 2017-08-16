package com.ol.olcx.CcHttp;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;



/**
 * Created by GW00070468 on 2017/8/14.
 */

public class CcHttp<T>  implements HttpTask<T>,ParamsTask<CcHttp<T>> {

    protected String url;
    protected Map<String,String> params=new HashMap<>();
    protected Map<String,String> headers=new HashMap<>();
    protected Object tag;
    protected Class<T> cls;
    protected CcRequest mCcRequest;

    protected HttpTask<T> mHttpTask;

    public CcHttp() {
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        cls = (Class<T>) superclass.getActualTypeArguments()[0];

    }

    public  CcHttp<T> get()
    {

        mHttpTask = new CcGetJson<T>();
        return this;
    }

    @Override
    public CcHttp<T> url(String url) {
        this.url=url;
        return this;
    }

    @Override
    public CcHttp<T> addParams(String key, String value) {
        params.put(key,value);
        return this;
    }

    @Override
    public CcHttp<T> addHeader(String key, String value) {
        headers.put(key,value);
        return this;
    }

    @Override
    public CcHttp<T> tag(String tag) {
        this.tag=tag;
        return this;
    }



    public void exucute(CcCallBack<T> ccCallBack) {
        mCcRequest=new CcRequest.Builder()
                .url(this.url)
                .tag(this.tag)
                .params(this.params)
                .headers(this.headers).build();
        mHttpTask.add(mCcRequest);
        mHttpTask.add(this.cls);
        mHttpTask.exucute(ccCallBack);
    }

    /**
     * 这里此接口没有使用
     * @param ccRequest
     */
    @Override
    public void add(CcRequest ccRequest) {
        mCcRequest=ccRequest;
    }

    @Override
    public void add(Class cls) {
        this.cls=cls;
    }

}

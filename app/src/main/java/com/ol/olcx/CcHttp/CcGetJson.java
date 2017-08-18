package com.ol.olcx.CcHttp;

import android.util.Log;

import com.google.gson.Gson;
import com.ol.olcx.CcLog;

import java.io.IOException;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by GW00070468 on 2017/8/15.
 */

class CcGetJson<T> extends CcResponse<T> implements ParamsTask<CcGetJson<T>>{

    private String url;
    private Request mRequest;
    private CcRequest mCcRequest;
    private Headers mHeaders;
    private OkHttpClient mOkHttpClient=null;
    private CcCallBack mCcCallBack;
    private Class<T> cls;

    public CcGetJson(CcRequest ccRequest) {
        mCcRequest = ccRequest;

    }

    public CcGetJson() {

        if (mOkHttpClient==null)
        {
            mOkHttpClient=new OkHttpClient();
        }
    }


    @Override
    public void exucute(final CcCallBack<T> ccCallBack) {

        mOkHttpClient.newCall(mRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ccCallBack.onFailure(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                CcLog.i("---CcGetJson",string);
                Observable.just(string)
                        .subscribeOn(Schedulers.io())
                        .map(new Function<String,Object>() {

                            @Override
                            public Object apply(@NonNull String s) throws Exception {
                                Gson gson = new Gson();
                                Object t = gson.fromJson(s, cls);

                                return t;
                            }
                        }).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Object>() {
                                       @Override
                                       public void accept(Object o) throws Exception {
                                           ccCallBack.onSuccess(((T) o));
                                       }
                                   });


            }
        });
    }

    @Override
    public CcGetJson<T> url(String url) {
        return this;
    }

    @Override
    public CcGetJson<T> addParams(String key, String value) {
        return this;
    }

    @Override
    public CcGetJson<T> addHeader(String key, String value) {
        return this;
    }

    @Override
    public CcGetJson<T> tag(String tag) {
        return this;
    }

    @Override
    public void add(CcRequest ccRequest) {
        this.mCcRequest=ccRequest;
        //url 拼接
        StringBuilder urlBuilder =null;
        Map<String, String> params = mCcRequest.mParams;
        Set<String> keySet = params.keySet();
        Iterator<String> iterator = keySet.iterator();

        String requestBaseUrl = mCcRequest.url+".do";
        if (!iterator.hasNext()){
            urlBuilder=new StringBuilder(requestBaseUrl);
        }
        while (iterator.hasNext()) {
            if (urlBuilder==null)
            {  urlBuilder=new StringBuilder(requestBaseUrl);
                String key = iterator.next();
                urlBuilder.append("?").append(key).append("=").append(params.get(key));
            }else {
                String key = iterator.next();
                urlBuilder.append("&").append(key).append("=").append(params.get(key));
            }
        }


        this.url=urlBuilder.toString();
        Log.i("---",this.url);
        // header拼接

        Headers.Builder builder = new Headers.Builder();
        Map<String, String> headers = mCcRequest.mHeaders;
        Set<Map.Entry<String, String>> entries = headers.entrySet();
        Iterator<Map.Entry<String, String>> headerIterator= entries.iterator();

        if (headerIterator.hasNext()) {
            Map.Entry<String, String> next = headerIterator.next();
            builder.add(next.getKey(),next.getValue());
        }
        mHeaders = builder.build();
        mRequest=new Request.Builder().url(this.url)
                .headers(this.mHeaders)
                .build();

    }

    @Override
    public void add(Class cls) {
        this.cls=cls;
    }

    public static class Builder<T> implements ParamsTask<Builder>
    {

        @Override
        public Builder url(String url) {
            return this;
        }

        @Override
        public Builder addParams(String key, String value) {
            return this;
        }

        @Override
        public Builder addHeader(String key, String value) {
            return this;
        }

        @Override
        public Builder tag(String tag) {
            return this;
        }
        public CcGetJson build()
        {
            return new CcGetJson<T>();
        }
    }



}

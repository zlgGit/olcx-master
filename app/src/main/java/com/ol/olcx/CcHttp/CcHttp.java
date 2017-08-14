package com.ol.olcx.CcHttp;

import android.content.Context;

import com.ol.olcx.CcHttp.OkHttp.OkHttpUtil;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by GW00070468 on 2017/8/14.
 */

public class CcHttp {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    String method;
    Request mRequest;
    RequestBody mRequestBody;
    Request.Builder mBuilder;

    private String url;

    public CcHttp(Context context) {

    }
    public  Request.Builder get()
    {
        method="GET";
        mBuilder=new Request.Builder();
        return mBuilder;
    }
    public Request.Builder postJson(String url,String json)
    {
        method="POST";
        mBuilder=new Request.Builder();
        mRequestBody=RequestBody.create(JSON,json);
        return mBuilder;
    }

    public Request.Builder postForm(String url,String json)
    {
        method="POST";
        mBuilder=new Request.Builder();
        return mBuilder;
    }

    public Request.Builder url(String url)
    {
        mBuilder.url(url);
        return mBuilder;
    }

    public Request.Builder addHeader(String key,String value)
    {
        mBuilder.addHeader(key,value);
        return mBuilder;
    }
    public Request.Builder addParam(String key,String value)
    {

        return mBuilder;
    }


}

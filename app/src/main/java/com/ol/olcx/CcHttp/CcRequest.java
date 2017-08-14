package com.ol.olcx.CcHttp;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by GW00070468 on 2017/8/14.
 */

public class CcRequest {
    String method;
    public Request OkhttpRequest;
    private String url;
    private Map<String,String> mParams=new HashMap<>();
    private Map<String,String> mHeaders=new HashMap<>();

    public CcRequest(Builder builder) {
        this.url=builder.url;
        this.mParams=builder.params;
        this.mHeaders=builder.headers;

    }

    public CcRequest() {
    }

    public static class Builder{
        private String url;
        private Map<String,String> params=new HashMap();
        private Map<String,String> headers=new HashMap<>();
        public Builder() {
        }
        public Builder url(String url)
        {
            this.url=url;
            return this;
        }
        public Builder addParam(String key,String value)
        {
            this.params.put(key,value);
            return this;
        }
        public Builder addParams(Map<String,String> params)
        {
            this.params=params;
            return this;
        }
        public Builder addHeader(String key,String value)
        {
            this.headers.put(key,value);
            return this;
        }
        public Builder addHeaders(Map<String,String> params)
        {
            this.headers=params;
            return this;
        }
        public CcRequest build()
        {
            return new CcRequest(this);
        }
    }
}

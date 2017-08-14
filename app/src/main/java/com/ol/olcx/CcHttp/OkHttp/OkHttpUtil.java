package com.ol.olcx.CcHttp.OkHttp;

import com.ol.olcx.CcHttp.CcCallBack;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by GW00070468 on 2017/8/14.
 */

public class OkHttpUtil {
    private static final OkHttpClient mOkHttpClient = new OkHttpClient();
    static{

    }


    /**
     * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
     * @param request
     */
    public static void enqueue(Request request, final CcCallBack mCcCallBack){

        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                mCcCallBack.onFailure(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Class<? extends CcCallBack> aClass = mCcCallBack.getClass();
                Type genericSuperclass = aClass.getGenericSuperclass();

                mCcCallBack.onSuccess(genericSuperclass);
            }

        });
    }
}

package com.ol.olcx.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.ol.olcx.CcHttp.CcHttp;
import com.ol.olcx.R;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected String initTitle() {
        return null;
    }


    @Override
    protected void imageLeftClick() {
        startActivity(new Intent(this,UserProfileActivity.class));
        OkHttpClient client = new OkHttpClient();


    }
}

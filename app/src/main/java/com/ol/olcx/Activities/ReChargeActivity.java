package com.ol.olcx.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.ol.olcx.R;

public class ReChargeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_re_charge);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected String initTitle() {
        return "充值";
    }


    @Override
    protected void imageLeftClick() {
        super.imageLeftClick();
        finish();
    }
}

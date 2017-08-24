package com.ol.olcx.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.ol.olcx.R;

import butterknife.ButterKnife;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected String initTitle() {
        return "设置";
    }

    @Override
    protected void imageLeftClick() {
        super.imageLeftClick();
        finish();
    }
}

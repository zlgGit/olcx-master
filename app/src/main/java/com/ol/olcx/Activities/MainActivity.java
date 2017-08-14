package com.ol.olcx.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.ol.olcx.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected View setBaseContentView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_main,null);
    }

    @Override
    protected void imageLeftClick() {
        startActivity(new Intent(this,UserProfileActivity.class));
    }
}

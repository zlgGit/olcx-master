package com.ol.olcx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImgLeft;
    private TextView mTxtLeft;
    private FrameLayout mBaseTitlCenter;
    private ImageView mImgRight;
    private TextView mTxtRight;
    private FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
        initViews();
        mContainer.addView(setBaseContentView());
    }

    private void initView() {
        mImgLeft = (ImageView) findViewById(R.id.base_image_left);
        mTxtLeft = (TextView) findViewById(R.id.base_txt_left);
        mBaseTitlCenter = (FrameLayout) findViewById(R.id.base_title_center);
        mImgRight = (ImageView) findViewById(R.id.base_image_right);
        mTxtRight = (TextView) findViewById(R.id.base_txt_right);
        mContainer = (FrameLayout) findViewById(R.id.base_container);
        mImgLeft.setOnClickListener(this);
        mTxtLeft.setOnClickListener(this);
        mImgRight.setOnClickListener(this);
        mImgLeft.setOnClickListener(this);
    }

    protected abstract void initViews();

    protected abstract View setBaseContentView();


    protected void setRightImage(int drawableId) {
        mImgRight.setImageResource(drawableId);
    }

    protected void setLeftImage(int drawableId) {
        mImgLeft.setImageResource(drawableId);
    }

    protected void setLeftTxt(int stringsId) {
        mTxtLeft.setText(getString(stringsId));
    }

    protected void setRightTxt(int stringsId) {
        mTxtRight.setText(getString(stringsId));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.base_image_left:
                imageLeftClick();
                break;
            case R.id.base_txt_left:
                txtLeftClick();
                break;
            case R.id.base_image_right:
                imageRightClick();
                break;
            case R.id.base_txt_right:
                txtRightClick();
                break;


        }
    }

    private void txtRightClick() {
    }

    private void imageRightClick() {
    }

    private void txtLeftClick() {
    }

    protected void imageLeftClick() {
    }


}

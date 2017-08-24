package com.ol.olcx.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ol.olcx.R;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImgLeft;
    private TextView mTxtLeft;
    private FrameLayout mBaseTitlCenter;
    private ImageView mImgRight;
    private TextView mTxtRight;
    private FrameLayout mContainer;
    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();

    }

    private void initView() {
        mImgLeft = (ImageView) findViewById(R.id.base_image_left);
        mTxtLeft = (TextView) findViewById(R.id.base_txt_left);
        mBaseTitlCenter = (FrameLayout) findViewById(R.id.base_title_center);
        mImgRight = (ImageView) findViewById(R.id.base_image_right);
        mTxtRight = (TextView) findViewById(R.id.base_txt_right);
        mContainer = (FrameLayout) findViewById(R.id.base_container);
        mTitle = (TextView) findViewById(R.id.title);
        mImgLeft.setOnClickListener(this);
        mTxtLeft.setOnClickListener(this);
        mImgRight.setOnClickListener(this);
        mImgLeft.setOnClickListener(this);
        mTitle.setText(initTitle());


    }

    protected abstract void initViews();

    protected abstract String initTitle();

    protected  void setBaseContentView(int id){
        mContainer.addView(LayoutInflater.from(this).inflate(id,null));
    }


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

    protected void txtRightClick() {
    }

    protected void imageRightClick() {
    }

    protected void txtLeftClick() {
    }

    protected void imageLeftClick() {
    }


}

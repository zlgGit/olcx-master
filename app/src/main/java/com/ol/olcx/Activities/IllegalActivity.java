package com.ol.olcx.Activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ol.olcx.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IllegalActivity extends BaseActivity {


    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.smartResfresh)
    SmartRefreshLayout mSmartResfresh;
    @BindView(R.id.content)
    FrameLayout mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_illegal);
        ButterKnife.bind(this);
        initViews();
    }

    @Override
    protected void initViews() {

        View view = LayoutInflater.from(this).inflate(R.layout.no_data, null);
        ((TextView) view.findViewById(R.id.no_data_tip)).setText(" 您目前没有违章记录，继续保持哦！");

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        mContent.addView(view, params);
    }

    @Override
    protected String initTitle() {
        return "违章记录";
    }


    @Override
    protected void imageLeftClick() {
        super.imageLeftClick();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}

package com.ol.olcx.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ol.olcx.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WalletActivity extends BaseActivity {


    @BindView(R.id.wallet_item1)
    LinearLayout mWalletItem1;
    @BindView(R.id.wallet_item2)
    LinearLayout mWalletItem2;
    @BindView(R.id.wallet_item3)
    LinearLayout mWalletItem3;
    @BindView(R.id.wallet_item4)
    LinearLayout mWalletItem4;
    @BindView(R.id.wallet_item5)
    LinearLayout mWalletItem5;
    @BindView(R.id.fresh_layout)
    SmartRefreshLayout mFreshLayout;
    @BindView(R.id.balance_available_mark)
    TextView mBalanceAvailableMark;
    @BindView(R.id.balance_money)
    TextView mBalanceMoney;
    @BindView(R.id.balance_notavailable)
    TextView mBalanceNotavailable;

    @Override
    protected void initViews() {

    }

    @Override
    protected String initTitle() {
        return "我的钱包";
    }


    @Override
    protected void imageLeftClick() {
        super.imageLeftClick();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        setBaseContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.wallet_item1, R.id.wallet_item2, R.id.wallet_item3, R.id.wallet_item4, R.id.wallet_item5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wallet_item1:

                Intent intent = new Intent(this, ReChargeActivity.class);
                startActivity(intent);
                break;
            case R.id.wallet_item2:
                break;
            case R.id.wallet_item3:
                break;
            case R.id.wallet_item4:
                break;
            case R.id.wallet_item5:
                break;
        }
    }
}

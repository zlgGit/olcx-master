package com.ol.olcx.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ol.olcx.R;
import com.ol.olcx.Respnses.CarResponse;
import com.ol.olcx.ViewHolders.CarListViewHolder;
import com.ol.olcx.beans.CarBean;

import java.util.List;

/**
 * Created by GW00070468 on 2017/8/18.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarListViewHolder> {

    private Context mContext;
    private List<CarBean> mCarBeans;

    public CarListAdapter(Context context, List<CarBean> carResponses) {
        mContext = context;
        mCarBeans = carResponses;
    }

    @Override
    public CarListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_car_info, parent, false);
        CarListViewHolder carListViewHolder = new CarListViewHolder(inflate);

        return carListViewHolder;
    }

    @Override
    public void onBindViewHolder(CarListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}

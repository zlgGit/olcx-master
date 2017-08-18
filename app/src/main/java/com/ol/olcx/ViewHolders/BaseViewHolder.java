package com.ol.olcx.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ol.olcx.R;

/**
 * Created by GW00070468 on 2017/8/18.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    private View mView;
    public BaseViewHolder(View itemView) {
        super(itemView);
        this.mView=itemView;
    }
    protected abstract void initViews();
    protected abstract void loadData(T t);
    public View findViewById(int id)
    {
       return mView.findViewById(id);
    }
}

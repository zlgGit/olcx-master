package com.ol.olcx.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ol.olcx.R;

import java.util.List;

/**
 * Created by GW00070468 on 2017/8/14.
 */

public class MapAdapter extends PagerAdapter {
    private List mList;
    private Context mContext;

    public MapAdapter( Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return true;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=null;
        if (position==0)
        {
            view= LayoutInflater.from(mContext).inflate(R.layout.map_vp_item1,null);
        }else {
            view= LayoutInflater.from(mContext).inflate(R.layout.map_vp_item2,null);
        }
        container.addView(view);
        return view;
    }




}

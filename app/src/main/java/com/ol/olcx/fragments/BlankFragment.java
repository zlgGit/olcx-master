package com.ol.olcx.fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps.SupportMapFragment;
import com.ol.olcx.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends SupportMapFragment {


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_blank, viewGroup,false);
    }
}

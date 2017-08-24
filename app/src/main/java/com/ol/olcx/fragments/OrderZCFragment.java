package com.ol.olcx.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ol.olcx.R;
import com.ol.olcx.adapters.CarListAdapter;
import com.ol.olcx.beans.CarBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderZCFragment extends PageFragment {

    public static OrderZCFragment newInstance() {
        
        Bundle args = new Bundle();
        
        OrderZCFragment fragment = new OrderZCFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @BindView(R.id.order_recyclerview)
    RecyclerView mOrderRecyclerview;
    Unbinder unbinder;

    public OrderZCFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_zc, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mOrderRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mOrderRecyclerview.setAdapter(new CarListAdapter(getActivity(), new ArrayList<CarBean>()))
        ;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public CharSequence getTitle() {
        return "专车订单";
    }
}

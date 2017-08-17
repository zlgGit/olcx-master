package com.ol.olcx.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.ol.olcx.CcConstant;
import com.ol.olcx.CcHttp.CcCallBack;
import com.ol.olcx.CcLog;
import com.ol.olcx.HttpInterfaces.CarStationHttp;
import com.ol.olcx.HttpInterfaces.CityStationHttp;
import com.ol.olcx.R;
import com.ol.olcx.beans.CarStationBean;
import com.ol.olcx.beans.DynamicBean;
import com.ol.olcx.beans.StationBean;
import com.ol.olcx.beans.StationInfoBean;
import com.ol.olcx.beans.StationResponse;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 *
 */
public class RentCarFragment extends FragmentBase {

    @BindView(R.id.rent_map)
    TextureMapView mRentMap;
    @BindView(R.id.location_bt)
    ImageView mLocationBt;
    @BindView(R.id.station_start_location)
    TextView mStationStartLocation;
    @BindView(R.id.station_choice_car)
    TextView mStationChoiceCar;
    @BindView(R.id.start_layout)
    LinearLayout mStartLayout;
    @BindView(R.id.station_end_location)
    TextView mStationEndLocation;
    @BindView(R.id.station_repalce)
    TextView mStationRepalce;
    @BindView(R.id.end_layout)
    LinearLayout mEndLayout;
    @BindView(R.id.rent_bottom)
    LinearLayout mRentBottom;
    Unbinder unbinder;
    private AMap mMap;
    private static String Tag=RentCarFragment.class.getSimpleName();

    public static RentCarFragment newInstance() {

        Bundle args = new Bundle();

        RentCarFragment fragment = new RentCarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static RentCarFragment newInstance(Bundle args) {

        RentCarFragment fragment = new RentCarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private TextureMapView textureMapView;

    public static final LatLng BAODING = new LatLng(38.816166, 115.452179);
    protected static CameraPosition cameraPosition;
    private List<Marker> mMarkerList;
    private Marker mCurrentMarker;

    public LatLng getTarget() {
        return BAODING;
    }

    public CameraPosition getCameraPosition() {
        return cameraPosition;
    }

    public void setCameraPosition(CameraPosition cameraPosition) {
        RentCarFragment.cameraPosition = cameraPosition;
    }

    public void initData() {
        mMarkerList = new ArrayList<>();
        CityStationHttp cityStationHttp = new CityStationHttp();
        cityStationHttp.getCityCarStaion("1500175").exucute(new CcCallBack<StationResponse>() {
            @Override
            public void onFailure(String error) {

            }

            @Override
            public void onSuccess(StationResponse stationResponse) {
                List<StationBean> data = stationResponse.data;

                for (StationBean bean:data
                     ) {
                    StationInfoBean basic = bean.basic;
                    DynamicBean dynamic = bean.dynamic;

                    MarkerOptions markerOptions = new MarkerOptions();
                    //这里很简单就加了一个TextView，根据需求可以加载复杂的View
                   BitmapDescriptor markerIcon = BitmapDescriptorFactory.fromView(getView(dynamic.getCarTotal()+"",CcConstant.COLOR_USSELECT));
                    double latitude = Double.parseDouble(basic.getLatitude());
                    double longitude = Double.parseDouble(basic.getLongitude());
                    LatLng latLng = new LatLng(latitude, longitude);
                    markerOptions.position(latLng).icon(markerIcon);
                    mMap.addMarker(markerOptions);

                }

            }
        });
    }


    private View getView(String count,int color) {
        View view = View.inflate(getActivity(), R.layout.custom_view, null);
        TextView textView = ((TextView) view.findViewById(R.id.title));
        switch (color) {
            case CcConstant.COLOR_SELECT:
                textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_poi_p));
                break;
            case CcConstant.COLOR_USSELECT:
                textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_poi_n));
                break;
        }

        textView.setText(count);
        return view;
    }

    // 定义 Marker 点击事件监听
    AMap.OnMarkerClickListener markerClickListener = new AMap.OnMarkerClickListener() {
        // marker 对象被点击时回调的接口
        // 返回 true 则表示接口已响应事件，否则返回false
        @Override
        public boolean onMarkerClick(Marker marker) {

            if (marker.equals(mCurrentMarker))
                return true;

            marker.getOptions().getIcon().recycle();


            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromView(getView("3", CcConstant.COLOR_SELECT));
            marker.setIcon(bitmapDescriptor);

            if (mCurrentMarker!=null)
            {
                mCurrentMarker.setIcon(BitmapDescriptorFactory.fromView(getView("3", CcConstant.COLOR_USSELECT)));
            }

            mCurrentMarker=marker;
            return true;
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rentcar, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textureMapView = (TextureMapView) getView().findViewById(R.id.rent_map);
        textureMapView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        if (textureMapView != null) {
            // 绑定 Marker 被点击事件
            mMap= textureMapView.getMap();

            mMap.setOnMarkerClickListener(markerClickListener);
            UiSettings uiSettings = mMap.getUiSettings();
            uiSettings.setZoomControlsEnabled(false);
            uiSettings.setScaleControlsEnabled(false);

            if (getCameraPosition() == null) {
                CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(getTarget(), 10, 0, 0));
                mMap.moveCamera(cameraUpdate);
            } else {
                mMap.moveCamera(CameraUpdateFactory.newCameraPosition(getCameraPosition()));
            }

        }
        if (textureMapView != null) {
            textureMapView.onCreate(savedInstanceState);
        }
        initData();
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onResume() {
        super.onResume();
//        textureMapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onPause() {
        super.onPause();
//        textureMapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        textureMapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onDestroy() {
        setCameraPosition(mMap.getCameraPosition());
        super.onDestroy();
        textureMapView.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

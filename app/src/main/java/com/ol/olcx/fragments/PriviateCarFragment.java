package com.ol.olcx.fragments;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.ol.olcx.CcHttp.CcCallBack;
import com.ol.olcx.HttpInterfaces.CarStationHttp;
import com.ol.olcx.R;
import com.ol.olcx.beans.CarStationBean;
import com.ol.olcx.beans.StationInfoBean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class PriviateCarFragment extends FragmentBase {


    public static PriviateCarFragment newInstance() {

        Bundle args = new Bundle();

        PriviateCarFragment fragment = new PriviateCarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static PriviateCarFragment newInstance(Bundle args) {

        PriviateCarFragment fragment = new PriviateCarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private TextureMapView textureMapView;
    public AMap aMap;

    public static final LatLng BAODING = new LatLng(38.816166,115.452179);
    protected static CameraPosition cameraPosition;
    private List<MarkerOptions> mMarkerOptionsList;

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
//        mMarkerOptionsList=new ArrayList<>();
//        CarStationHttp carStationHttp = new CarStationHttp();
//        carStationHttp.getAllCarStaion().exucute(new CcCallBack<CarStationBean>() {
//
//            private List<StationInfoBean> mStationInfo;
//
//            @Override
//            public void onFailure(String error) {
//
//            }
//
//            @Override
//            public void onSuccess(CarStationBean carStationBean) {
//                mStationInfo = carStationBean.getData();
//                for (int i = 0; i < mStationInfo.size(); i++) {
//
//                    StationInfoBean stationInfoBean = mStationInfo.get(i);
//                    MarkerOptions markerOptions = new MarkerOptions();
//                    //这里很简单就加了一个TextView，根据需求可以加载复杂的View
//                    View view = View.inflate(getActivity(), R.layout.custom_view, null);
//                    TextView textView = ((TextView) view.findViewById(R.id.title));
//                    textView.setText("3");
//                    BitmapDescriptor markerIcon = BitmapDescriptorFactory.fromView(view);
//                    double latitude = Double.parseDouble(stationInfoBean.getLatitude());
//                    double longitude = Double.parseDouble(stationInfoBean.getLongitude());
//                    LatLng latLng = new LatLng(latitude, longitude);
//                    markerOptions.position(latLng).icon(markerIcon);
//                    aMap.addMarker(markerOptions);
//
//                }
//            }
//        });
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment, container, false);
        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textureMapView = (TextureMapView) getView().findViewById(R.id.map);
        AMap map = textureMapView.getMap();
        UiSettings uiSettings = map.getUiSettings();
        uiSettings.setZoomControlsEnabled(false);
        uiSettings.setScaleControlsEnabled(true);
        textureMapView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        if (textureMapView != null) {
            textureMapView.onCreate(savedInstanceState);
            aMap = textureMapView.getMap();
            if (getCameraPosition() == null) {
                aMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(getTarget(), 10, 0, 0)));
            }else {
                aMap.moveCamera(CameraUpdateFactory.newCameraPosition(getCameraPosition()));
            }
        }
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
        setCameraPosition(aMap.getCameraPosition());
        super.onDestroy();
        textureMapView.onDestroy();
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

}

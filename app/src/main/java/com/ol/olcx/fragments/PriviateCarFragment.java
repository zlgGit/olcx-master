package com.ol.olcx.fragments;



import android.view.View;
import android.widget.TextView;

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

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class PriviateCarFragment extends FragmentBase {


    public static final LatLng BAODING = new LatLng(38.816166,115.452179);
    protected static CameraPosition cameraPosition;
    private List<MarkerOptions> mMarkerOptionsList;
    @Override
    LatLng getTarget() {
        return BAODING;
    }

    @Override
    CameraPosition getCameraPosition() {
        return cameraPosition;
    }

    @Override
    void setCameraPosition(CameraPosition cameraPosition) {
        PriviateCarFragment.cameraPosition = cameraPosition;
    }

    @Override
    protected void initData() {
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
}

package com.ol.olcx.fragments;


import android.content.Intent;
import android.os.Bundle;
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
import com.ol.olcx.Activities.ChoiceCarActivity;
import com.ol.olcx.CcConstant;
import com.ol.olcx.CcHttp.CcCallBack;
import com.ol.olcx.HttpInterfaces.CityStationHttp;
import com.ol.olcx.R;
import com.ol.olcx.Respnses.StationResponse;
import com.ol.olcx.beans.DynamicBean;
import com.ol.olcx.beans.StationBean;
import com.ol.olcx.beans.StationInfoBean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    @BindView(R.id.txt_end_station_repalce)
    TextView mTxtStationRepalce;
    @BindView(R.id.end_layout)
    LinearLayout mEndLayout;
    @BindView(R.id.rent_bottom)
    LinearLayout mRentBottom;
    Unbinder unbinder;
    private AMap mMap;
    private static String Tag = RentCarFragment.class.getSimpleName();

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
    private List<Marker> mMarkerList;//所有marker
    private Marker mCurrentMarker;//当前marker
    private List<StationBean> mData;//所有maker的数据

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
                //数据回来先清理数据
                mMap.clear();
                mData.clear();
                mData = stationResponse.data;

                for (int i = 0; i < mData.size(); i++) {

                    StationBean bean = mData.get(i);
                    StationInfoBean basic = bean.basic;
                    DynamicBean dynamic = bean.dynamic;

                    MarkerOptions markerOptions = new MarkerOptions();
                    //这里很简单就加了一个TextView，根据需求可以加载复杂的View
                    BitmapDescriptor markerIcon = BitmapDescriptorFactory.fromView(getView(dynamic.getCarTotal() + "", CcConstant.COLOR_USSELECT));
                    double latitude = Double.parseDouble(basic.getLatitude());
                    double longitude = Double.parseDouble(basic.getLongitude());
                    LatLng latLng = new LatLng(latitude, longitude);
                    markerOptions.position(latLng).icon(markerIcon).snippet(i + "");
                    mMap.addMarker(markerOptions);
                }

            }
        });
    }


    private View getView(String count, int color) {
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

            if (marker.equals(mCurrentMarker))//点击同一个marker
                return true;



            MarkerOptions options = marker.getOptions();
            options.getIcon().recycle();
            //点击站点给当前位置输入值
            String snippet = options.getSnippet();
            StationBean stationBean = mData.get(Integer.parseInt(snippet));
            if (stationBean!=null)
            {

                mStationStartLocation.setText(stationBean.basic.getName());
                mStationStartLocation.setTag(stationBean);
            }

            //点击图标改变，点击的maker和当前的marker背景交换
            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromView(getView(options.getSnippet(), CcConstant.COLOR_SELECT));
            marker.setIcon(bitmapDescriptor);

            if (mCurrentMarker != null) {
                mCurrentMarker.setIcon(BitmapDescriptorFactory.fromView(getView(mCurrentMarker.getSnippet(), CcConstant.COLOR_USSELECT)));
            }

            mCurrentMarker = marker;
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
        mData=new ArrayList<>();
        textureMapView = (TextureMapView) getView().findViewById(R.id.rent_map);
        textureMapView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        if (textureMapView != null) {
            // 绑定 Marker 被点击事件
            mMap = textureMapView.getMap();

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

    @OnClick({R.id.location_bt, R.id.station_start_location, R.id.station_choice_car, R.id.station_end_location, R.id.txt_end_station_repalce})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.location_bt:
                break;

            case R.id.station_start_location:
                break;

            case R.id.station_choice_car:
                Intent intent = new Intent(getActivity(), ChoiceCarActivity.class);
                StationBean stationBean = (StationBean) mStationStartLocation.getTag();
                int id = stationBean.basic.getId();
                intent.putExtra(CcConstant.STATIONID,id);
                startActivityForResult(intent,CcConstant.JUMP_STATION_SELECTED_CAR);
                break;

            case R.id.station_end_location:
                break;

            case R.id.txt_end_station_repalce:

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==CcConstant.JUMP_STATION_SELECTED_CAR)
        {

        }
    }
}

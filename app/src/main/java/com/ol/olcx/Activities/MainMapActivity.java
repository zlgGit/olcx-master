package com.ol.olcx.Activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.ol.olcx.R;
import com.ol.olcx.SensorEventHelper;

public class MainMapActivity extends AppCompatActivity {

    private LinearLayout mContainer;
    private AMap mMap;
    private LocationManager mLocationManager=null;
    private AMapLocation mLocation;
    private LinearLayout.LayoutParams mParams;
    private MapView mMapView;
    private Marker locationMarker;
    private SensorEventHelper mSensorHelper;
    private Marker mLocMarker;

    private boolean mFirstFix = false;

    private Circle mCircle;
    private static final int STROKE_COLOR = Color.argb(180, 3, 145, 255);
    private static final int FILL_COLOR = Color.argb(10, 0, 0, 180);
    public static final String LOCATION_MARKER_FLAG = "mylocation";

    public String [] locationPermission={Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};

    private Handler mHandler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            return true;
        }
    });

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_map);
        mMapView = (MapView) findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);

        if (chceckPeimisions(locationPermission)) {
            initMap();
        }else {
            requestPemission(locationPermission);
        }



    }

    private void initMap() {


        mLocationManager=new LocationManager();
        mContainer = (LinearLayout) findViewById(R.id.map_container);

        mLocationManager.init(this);

//        LatLng latLng = new LatLng(31.238068, 121.501654);
//        CameraPosition LUJIAZUI = new CameraPosition.Builder()
//                .target(latLng).zoom(18).bearing(0).tilt(30).build();

//        AMapOptions aOptions = new AMapOptions();
//        aOptions.zoomGesturesEnabled(false);// 禁止通过手势缩放地图
//        aOptions.scrollGesturesEnabled(false);// 禁止通过手势移动地图
//        aOptions.tiltGesturesEnabled(false);// 禁止通过手势倾斜地图
//        aOptions.camera(LUJIAZUI);

//        mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        mContainer.addView(mMapView, mParams);

        mMap = mMapView.getMap();

//        MarkerOptions defaultMarker = new MarkerOptions().position(latLng) .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
//                .decodeResource(getResources(),R.mipmap.ic_launcher))).title("").snippet("DefaultMarker");



        mMap.setOnCameraChangeListener(new AMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                LatLng target = cameraPosition.target;
                Log.i("---",target.latitude+"  "+target.longitude);
                locationMarker.setPosition(target);
            }

            @Override
            public void onCameraChangeFinish(CameraPosition cameraPosition) {

            }
        });
        mMap.setOnMapLoadedListener(new AMap.OnMapLoadedListener() {
            @Override
            public void onMapLoaded() {
                addMarkerInScreenCenter(null);
            }
        });

        intiP();
        setUpMap();
    }

    private void requestPemission(String [] locationPermission) {
        ActivityCompat.requestPermissions(this,locationPermission,100);
    }

    private boolean chceckPeimisions(String[] locationPermission) {

        for (int i = 0; i < locationPermission.length; i++) {
            boolean b = ContextCompat.checkSelfPermission(this, locationPermission[i]) == PackageManager.PERMISSION_DENIED;
           return b;
        }
        return true;
    }

    private void intiP() {
        if (mMap == null) {
            mMap = mMapView.getMap();
            setUpMap();
        }
        mSensorHelper = new SensorEventHelper(this);
        if (mSensorHelper != null) {
            mSensorHelper.registerSensorListener();
        }



    }

    private void initView() {


    }

    /**
     * 设置一些amap的属性
     */
    private void setUpMap() {
        mMap.setLocationSource(new LocationSource() {
            @Override
            public void activate(OnLocationChangedListener onLocationChangedListener) {
                mLocationManager.startLocation(new LocationManager.LocationSuccess() {
                    @Override
                    public void success() {
                        mLocation=mLocationManager.getLocation();
                        double latitude = mLocation.getLatitude();
                        double longitude = mLocation.getLongitude();
                        LatLng location = new LatLng(mLocation.getLatitude(), mLocation.getLongitude());
                        if (!mFirstFix) {
                            mFirstFix = true;
//                            addCircle(location, mLocation.getAccuracy());//添加定位精度圆
                            addMarker(location);//添加定位图标
                            mSensorHelper.setCurrentMarker(mLocMarker);//定位图标旋转
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,18));
                        } else {
//                            mCircle.setCenter(location);
//                            mCircle.setRadius(mLocation.getAccuracy());
                            mLocMarker.setPosition(location);
                            mMap.moveCamera(CameraUpdateFactory.changeLatLng(location));
                        }
                    }
                });
            }

            @Override
            public void deactivate() {

            }
        });// 设置定位监听
        mMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        mMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        // 设置定位的类型为定位模式 ，可以由定位、跟随或地图根据面向方向旋转几种
        mMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        if (mLocMarker != null) {
            mLocMarker.destroy();
        }
    }

    @Override
    protected void onResume() {
        initView();
        super.onResume();
        mMapView.onResume();
        if (mSensorHelper != null) {
            mSensorHelper.registerSensorListener();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
        mFirstFix = false;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mMapView.onSaveInstanceState(outState);
    }

    private void addMarkerInScreenCenter(LatLng locationLatLng) {
        LatLng latLng = mMap.getCameraPosition().target;
        Point screenPosition = mMap.getProjection().toScreenLocation(latLng);
        locationMarker = mMap.addMarker(new MarkerOptions()
                .anchor(0.5f,0.5f)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.poi_marker_pressed)));
        //设置Marker在屏幕上,不跟随地图移动
        locationMarker.setPositionByPixels(screenPosition.x,screenPosition.y);
        locationMarker.setZIndex(1);

    }


    private void addMarker(LatLng latlng) {
        if (mLocMarker != null) {
            return;
        }
        MarkerOptions options = new MarkerOptions();
        options.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(this.getResources(),
                R.mipmap.navi_map_gps_locked)));
        options.anchor(0.5f, 0.5f);
        options.position(latlng);
        mLocMarker = mMap.addMarker(options);
        mLocMarker.setTitle("");
    }


    private void addCircle(LatLng latlng, double radius) {
        CircleOptions options = new CircleOptions();
        options.strokeWidth(1f);
        options.fillColor(FILL_COLOR);
        options.strokeColor(STROKE_COLOR);
        options.center(latlng);
        options.radius(radius);
        mCircle = mMap.addCircle(options);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==100)
        {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i]==PackageManager.PERMISSION_DENIED)
                {
                    return;
                }
            }
            initMap();
        }
    }
}

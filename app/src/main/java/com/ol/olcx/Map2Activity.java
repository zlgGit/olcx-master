package com.ol.olcx;

import android.graphics.BitmapFactory;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;

public class Map2Activity extends AppCompatActivity {

    private MapView mMapView;
    private AMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);
        mMapView = (MapView) findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);
        mMap = mMapView.getMap();
        final LocationManager locationManager = new LocationManager();
        locationManager.init(this);
        locationManager.startLocation(new LocationManager.LocationSuccess() {
            @Override
            public void success() {
                AMapLocation location = locationManager.getLocation();

                LatLng latLng = new LatLng(31.238068, 121.501654);
                //draw icon
                MarkerOptions defaultMarker = new MarkerOptions().position(latLng) .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                        .decodeResource(getResources(),R.mipmap.ic_launcher))).title("").snippet("DefaultMarker");

                Marker marker = mMap.addMarker(defaultMarker);

                //移动地图
                CameraPosition LUJIAZUI = new CameraPosition.Builder()
                .target(latLng).zoom(18).bearing(0).tilt(30).build();
                mMap.moveCamera(CameraUpdateFactory.newCameraPosition(LUJIAZUI));

            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mMapView.onSaveInstanceState(outState);
    }
}

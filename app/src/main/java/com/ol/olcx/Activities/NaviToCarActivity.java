package com.ol.olcx.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviException;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.AMapNaviViewListener;
import com.amap.api.navi.AMapNaviViewOptions;
import com.amap.api.navi.enums.NaviType;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.view.RouteOverLay;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import com.autonavi.tbt.TrafficFacilityInfo;
import com.ol.olcx.CcLog;
import com.ol.olcx.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NaviToCarActivity extends Activity implements AMapNaviListener {
    @BindView(R.id.map)
    MapView mMapView;
    private NaviLatLng endLatlng = new NaviLatLng(39.90759, 116.392582);
    private NaviLatLng startLatlng = new NaviLatLng(39.993537, 114.472875);
    private AMapNavi mInstance;
    private AMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi_to_car);
        ButterKnife.bind(this);
        mInstance = AMapNavi.getInstance(getApplicationContext());
//添加监听回调，用于处理算路成功
        mInstance.addAMapNaviListener(this);
        mMapView.onCreate(savedInstanceState);
        mMap = mMapView.getMap();

        RouteSearch routeSearch = new RouteSearch(this);

        routeSearch.setRouteSearchListener(new RouteSearch.OnRouteSearchListener() {
            @Override
            public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

            }

            @Override
            public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i) {

            }

            @Override
            public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {

            }

            @Override
            public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

            }
        });

    }

    @OnClick(R.id.map)
    public void onViewClicked() {
    }

    @Override
    public void onInitNaviFailure() {

    }

    @Override
    public void onInitNaviSuccess() {
        CcLog.i("---onInitNaviSuccess", "onInitNaviSuccess");
        mInstance.calculateWalkRoute(startLatlng, endLatlng);
    }

    @Override
    public void onStartNavi(int i) {

    }

    @Override
    public void onTrafficStatusUpdate() {

    }

    @Override
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

    }

    @Override
    public void onGetNavigationText(int i, String s) {

    }

    @Override
    public void onGetNavigationText(String s) {

    }

    @Override
    public void onEndEmulatorNavi() {

    }

    @Override
    public void onArriveDestination() {

    }

    @Override
    public void onCalculateRouteFailure(int i) {

    }

    @Override
    public void onReCalculateRouteForYaw() {

    }

    @Override
    public void onReCalculateRouteForTrafficJam() {

    }

    @Override
    public void onArrivedWayPoint(int i) {

    }

    @Override
    public void onGpsOpenStatus(boolean b) {

    }

    @Override
    public void onNaviInfoUpdate(NaviInfo naviInfo) {

    }

    @Override
    public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {

    }

    @Override
    public void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfos) {

    }

    @Override
    public void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfos) {

    }

    @Override
    public void showCross(AMapNaviCross aMapNaviCross) {

    }

    @Override
    public void hideCross() {

    }

    @Override
    public void showLaneInfo(AMapLaneInfo[] aMapLaneInfos, byte[] bytes, byte[] bytes1) {

    }

    @Override
    public void hideLaneInfo() {

    }

    @Override
    public void onCalculateRouteSuccess(int[] ints) {

        mMap.setMapType(AMap.MAP_TYPE_NAVI);

//        mMap.
    }

    @Override
    public void notifyParallelRoad(int i) {

    }

    @Override
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {

    }

    @Override
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfos) {

    }

    @Override
    public void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {

    }

    @Override
    public void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {

    }

    @Override
    public void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {

    }

    @Override
    public void onPlayRing(int i) {

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
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    /**
     * @param paths 多路线回调路线
     * @param ints  多路线回调路线ID
     */
    private void setRouteLineTag(HashMap<Integer, AMapNaviPath> paths, int[] ints) {
//        if (ints.length < 1) {
//            visiableRouteLine(false, false, false);
//            return;
//        }
//        int indexOne = 0;
//        String stragegyTagOne = paths.get(ints[indexOne]).getLabels();
//        setLinelayoutOneContent(ints[indexOne], stragegyTagOne);
//        if (ints.length == 1) {
//            visiableRouteLine(true, false, false);
//            focuseRouteLine(true, false, false);
//            return;
//        }
//
//        int indexTwo = 1;
//        String stragegyTagTwo = paths.get(ints[indexTwo]).getLabels();
//        setLinelayoutTwoContent(ints[indexTwo], stragegyTagTwo);
//        if (ints.length == 2) {
//            visiableRouteLine(true, true, false);
//            focuseRouteLine(true, false, false);
//            return;
//        }
//
//        int indexThree = 2;
//        String stragegyTagThree = paths.get(ints[indexThree]).getLabels();
//        setLinelayoutThreeContent(ints[indexThree], stragegyTagThree);
//        if (ints.length >= 3) {
//            visiableRouteLine(true, true, true);
//            focuseRouteLine(true, false, false);
//        }

    }

    /**
     * 绘制路径规划结果
     *
     * @param routeId 路径规划线路ID
     * @param path    AMapNaviPath
     */
    private void drawRoutes(int routeId, AMapNaviPath path) {
        mMap.moveCamera(CameraUpdateFactory.changeTilt(0));
        RouteOverLay routeOverLay = new RouteOverLay(mMap, path, this);
        try {
            routeOverLay.setWidth(60f);
        } catch (AMapNaviException e) {
            e.printStackTrace();
        }
        routeOverLay.setTrafficLine(true);
        routeOverLay.addToMap();
        routeOverlays.put(routeId, routeOverLay);
    }


    private void cleanRouteOverlay() {
        for (int i = 0; i < routeOverlays.size(); i++) {
            int key = routeOverlays.keyAt(i);
            RouteOverLay overlay = routeOverlays.get(key);
            overlay.removeFromMap();
            overlay.destroy();
        }
        routeOverlays.clear();
    }

    /**
     * 保存当前算好的路线
     */
    private SparseArray<RouteOverLay> routeOverlays = new SparseArray<RouteOverLay>();

    /**
     * 路线tag选中设置
     *
     * @param lineOne
     * @param lineTwo
     * @param lineThree
     */
    private void focuseRouteLine(boolean lineOne, boolean lineTwo, boolean lineThree) {
        Log.d("LG", "lineOne:" + lineOne + " lineTwo:" + lineTwo + " lineThree:" + lineThree);
//        setLinelayoutOne(lineOne);
//        setLinelayoutTwo(lineTwo);
//        setLinelayoutThree(lineThree);
//        keytool -list -v -keystore test.jks
    }
}

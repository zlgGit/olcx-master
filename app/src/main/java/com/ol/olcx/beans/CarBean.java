package com.ol.olcx.beans;

import com.ol.olcx.Respnses.CarResponse;

import java.util.List;

/**
 * Created by GW00070468 on 2017/8/18.
 */

public class CarBean extends BaseBean {

    /**
     * id : 1
     * modeId : 2
     * stationId : 1
     * statId : 1
     * color : blue
     * plateNum : 1
     * vinCode : 1
     * tboxId : 1
     * type : 1
     * age : 1
     * lastCleanDate : 1503038090000
     * business : 1
     * status : 1
     * carDynamic : {"id":1,"stationId":1,"vinCode":"1","longitude":"1","latitude":"1","mileage":1,"charging":1}
     */

    public int id;
    public int modeId;
    public int stationId;
    public int statId;
    public String color;
    public String plateNum;
    public String vinCode;
    public String tboxId;
    public String type;
    public int age;
    public long lastCleanDate;
    public int business;
    public int status;
    public CarDynamicBean carDynamic;


}

package com.ol.olcx.beans;

import java.io.Serializable;

/**
 * Created by GW00070468 on 2017/8/15.
 */

public class StationInfoBean implements Serializable {
    private int id;
    private Object imageurl;
    private String name;
    private int discount;
    private int reduction;
    private int opentime;
    private int closetime;
    private String type;
    private String longitude;
    private String latitude;
    private String address;
    private String addressDescription;
    private String parkings;
    private String chargers;
    private String cityCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getImageurl() {
        return imageurl;
    }

    public void setImageurl(Object imageurl) {
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public int getOpentime() {
        return opentime;
    }

    public void setOpentime(int opentime) {
        this.opentime = opentime;
    }

    public int getClosetime() {
        return closetime;
    }

    public void setClosetime(int closetime) {
        this.closetime = closetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    public String getParkings() {
        return parkings;
    }

    public void setParkings(String parkings) {
        this.parkings = parkings;
    }

    public String getChargers() {
        return chargers;
    }

    public void setChargers(String chargers) {
        this.chargers = chargers;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}

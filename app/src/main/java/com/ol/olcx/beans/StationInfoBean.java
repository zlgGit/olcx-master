package com.ol.olcx.beans;

import java.io.Serializable;

/**
 * Created by GW00070468 on 2017/8/15.
 */

public class StationInfoBean implements Serializable {
    public int id;
    public String imageurl;
    public String name;
    public double discount;
    public int reduction;
    public int opentime;
    public int closetime;
    public String type;
    public String longitude;
    public String latitude;
    public String address;
    public String addressDescription;
    public String parkings;
    public String chargers;
    public String cityCode;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getImageurl() {
        return imageurl;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

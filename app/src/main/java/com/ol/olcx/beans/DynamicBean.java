package com.ol.olcx.beans;

/**
 * Created by gw00070468 on 2017/8/17.
 */

public class DynamicBean extends BaseBean{

    /**
     * id : 1
     * carTotal : 100
     * parkings : 20
     * parkingsTotal : 100
     * chargers : 0
     * chargersTotal : 100
     */

    public int id;
    public int carTotal;
    public int parkings;
    public int parkingsTotal;
    public int chargers;
    public int chargersTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarTotal() {
        return carTotal;
    }

    public void setCarTotal(int carTotal) {
        this.carTotal = carTotal;
    }

    public int getParkings() {
        return parkings;
    }

    public void setParkings(int parkings) {
        this.parkings = parkings;
    }

    public int getParkingsTotal() {
        return parkingsTotal;
    }

    public void setParkingsTotal(int parkingsTotal) {
        this.parkingsTotal = parkingsTotal;
    }

    public int getChargers() {
        return chargers;
    }

    public void setChargers(int chargers) {
        this.chargers = chargers;
    }

    public int getChargersTotal() {
        return chargersTotal;
    }

    public void setChargersTotal(int chargersTotal) {
        this.chargersTotal = chargersTotal;
    }
}

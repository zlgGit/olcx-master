package com.ol.olcx.beans;

/**
 * Created by gw00070468 on 2017/8/17.
 */

public class DynamicBean {

    /**
     * id : 1
     * carTotal : 100
     * parkings : 20
     * parkingsTotal : 100
     * chargers : 0
     * chargersTotal : 100
     */

    private int id;
    private int carTotal;
    private int parkings;
    private int parkingsTotal;
    private int chargers;
    private int chargersTotal;

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

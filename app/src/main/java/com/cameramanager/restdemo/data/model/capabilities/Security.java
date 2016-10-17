
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Security {

    @SerializedName("open")
    @Expose
    private boolean open;
    @SerializedName("wep")
    @Expose
    private boolean wep;
    @SerializedName("wpa")
    @Expose
    private Wpa wpa;
    @SerializedName("wpa2")
    @Expose
    private Wpa2 wpa2;

    /**
     * 
     * @return
     *     The open
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * 
     * @param open
     *     The open
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    public Security withOpen(boolean open) {
        this.open = open;
        return this;
    }

    /**
     * 
     * @return
     *     The wep
     */
    public boolean isWep() {
        return wep;
    }

    /**
     * 
     * @param wep
     *     The wep
     */
    public void setWep(boolean wep) {
        this.wep = wep;
    }

    public Security withWep(boolean wep) {
        this.wep = wep;
        return this;
    }

    /**
     * 
     * @return
     *     The wpa
     */
    public Wpa getWpa() {
        return wpa;
    }

    /**
     * 
     * @param wpa
     *     The wpa
     */
    public void setWpa(Wpa wpa) {
        this.wpa = wpa;
    }

    public Security withWpa(Wpa wpa) {
        this.wpa = wpa;
        return this;
    }

    /**
     * 
     * @return
     *     The wpa2
     */
    public Wpa2 getWpa2() {
        return wpa2;
    }

    /**
     * 
     * @param wpa2
     *     The wpa2
     */
    public void setWpa2(Wpa2 wpa2) {
        this.wpa2 = wpa2;
    }

    public Security withWpa2(Wpa2 wpa2) {
        this.wpa2 = wpa2;
        return this;
    }

}

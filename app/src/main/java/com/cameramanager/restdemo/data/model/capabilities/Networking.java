
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Networking {

    @SerializedName("ethernet")
    @Expose
    private Ethernet ethernet;
    @SerializedName("wifi")
    @Expose
    private Wifi wifi;

    /**
     * 
     * @return
     *     The ethernet
     */
    public Ethernet getEthernet() {
        return ethernet;
    }

    /**
     * 
     * @param ethernet
     *     The ethernet
     */
    public void setEthernet(Ethernet ethernet) {
        this.ethernet = ethernet;
    }

    public Networking withEthernet(Ethernet ethernet) {
        this.ethernet = ethernet;
        return this;
    }

    /**
     * 
     * @return
     *     The wifi
     */
    public Wifi getWifi() {
        return wifi;
    }

    /**
     * 
     * @param wifi
     *     The wifi
     */
    public void setWifi(Wifi wifi) {
        this.wifi = wifi;
    }

    public Networking withWifi(Wifi wifi) {
        this.wifi = wifi;
        return this;
    }

}

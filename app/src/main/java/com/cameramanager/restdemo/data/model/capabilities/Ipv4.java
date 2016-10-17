
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ipv4 {

    @SerializedName("manual")
    @Expose
    private boolean manual;
    @SerializedName("dhcp")
    @Expose
    private boolean dhcp;
    @SerializedName("status")
    @Expose
    private boolean status;

    /**
     * 
     * @return
     *     The manual
     */
    public boolean isManual() {
        return manual;
    }

    /**
     * 
     * @param manual
     *     The manual
     */
    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public Ipv4 withManual(boolean manual) {
        this.manual = manual;
        return this;
    }

    /**
     * 
     * @return
     *     The dhcp
     */
    public boolean isDhcp() {
        return dhcp;
    }

    /**
     * 
     * @param dhcp
     *     The dhcp
     */
    public void setDhcp(boolean dhcp) {
        this.dhcp = dhcp;
    }

    public Ipv4 withDhcp(boolean dhcp) {
        this.dhcp = dhcp;
        return this;
    }

    /**
     * 
     * @return
     *     The status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    public Ipv4 withStatus(boolean status) {
        this.status = status;
        return this;
    }

}


package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Config {

    @SerializedName("disable")
    @Expose
    private boolean disable;
    @SerializedName("ipv4")
    @Expose
    private Ipv4 ipv4;

    /**
     * 
     * @return
     *     The disable
     */
    public boolean isDisable() {
        return disable;
    }

    /**
     * 
     * @param disable
     *     The disable
     */
    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public Config withDisable(boolean disable) {
        this.disable = disable;
        return this;
    }

    /**
     * 
     * @return
     *     The ipv4
     */
    public Ipv4 getIpv4() {
        return ipv4;
    }

    /**
     * 
     * @param ipv4
     *     The ipv4
     */
    public void setIpv4(Ipv4 ipv4) {
        this.ipv4 = ipv4;
    }

    public Config withIpv4(Ipv4 ipv4) {
        this.ipv4 = ipv4;
        return this;
    }

}


package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wpa {

    @SerializedName("psk")
    @Expose
    private boolean psk;
    @SerializedName("wps")
    @Expose
    private boolean wps;

    /**
     * 
     * @return
     *     The psk
     */
    public boolean isPsk() {
        return psk;
    }

    /**
     * 
     * @param psk
     *     The psk
     */
    public void setPsk(boolean psk) {
        this.psk = psk;
    }

    public Wpa withPsk(boolean psk) {
        this.psk = psk;
        return this;
    }

    /**
     * 
     * @return
     *     The wps
     */
    public boolean isWps() {
        return wps;
    }

    /**
     * 
     * @param wps
     *     The wps
     */
    public void setWps(boolean wps) {
        this.wps = wps;
    }

    public Wpa withWps(boolean wps) {
        this.wps = wps;
        return this;
    }

}

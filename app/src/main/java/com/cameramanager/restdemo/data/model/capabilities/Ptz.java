
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ptz {

    @SerializedName("panTilt")
    @Expose
    private boolean panTilt;
    @SerializedName("zoom")
    @Expose
    private boolean zoom;

    /**
     * 
     * @return
     *     The panTilt
     */
    public boolean isPanTilt() {
        return panTilt;
    }

    /**
     * 
     * @param panTilt
     *     The panTilt
     */
    public void setPanTilt(boolean panTilt) {
        this.panTilt = panTilt;
    }

    public Ptz withPanTilt(boolean panTilt) {
        this.panTilt = panTilt;
        return this;
    }

    /**
     * 
     * @return
     *     The zoom
     */
    public boolean isZoom() {
        return zoom;
    }

    /**
     * 
     * @param zoom
     *     The zoom
     */
    public void setZoom(boolean zoom) {
        this.zoom = zoom;
    }

    public Ptz withZoom(boolean zoom) {
        this.zoom = zoom;
        return this;
    }

}

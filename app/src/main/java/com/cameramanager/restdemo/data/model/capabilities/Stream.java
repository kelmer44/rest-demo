
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stream {

    @SerializedName("jpeg")
    @Expose
    private boolean jpeg;
    @SerializedName("h264")
    @Expose
    private boolean h264;

    /**
     * 
     * @return
     *     The jpeg
     */
    public boolean isJpeg() {
        return jpeg;
    }

    /**
     * 
     * @param jpeg
     *     The jpeg
     */
    public void setJpeg(boolean jpeg) {
        this.jpeg = jpeg;
    }

    public Stream withJpeg(boolean jpeg) {
        this.jpeg = jpeg;
        return this;
    }

    /**
     * 
     * @return
     *     The h264
     */
    public boolean isH264() {
        return h264;
    }

    /**
     * 
     * @param h264
     *     The h264
     */
    public void setH264(boolean h264) {
        this.h264 = h264;
    }

    public Stream withH264(boolean h264) {
        this.h264 = h264;
        return this;
    }

}

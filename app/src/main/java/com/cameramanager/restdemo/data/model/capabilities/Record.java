
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Record {

    @SerializedName("cloud")
    @Expose
    private Cloud cloud;
    @SerializedName("sd")
    @Expose
    private boolean sd;

    /**
     * 
     * @return
     *     The cloud
     */
    public Cloud getCloud() {
        return cloud;
    }

    /**
     * 
     * @param cloud
     *     The cloud
     */
    public void setCloud(Cloud cloud) {
        this.cloud = cloud;
    }

    public Record withCloud(Cloud cloud) {
        this.cloud = cloud;
        return this;
    }

    /**
     * 
     * @return
     *     The sd
     */
    public boolean isSd() {
        return sd;
    }

    /**
     * 
     * @param sd
     *     The sd
     */
    public void setSd(boolean sd) {
        this.sd = sd;
    }

    public Record withSd(boolean sd) {
        this.sd = sd;
        return this;
    }

}

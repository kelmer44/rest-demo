
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pir {

    @SerializedName("stream")
    @Expose
    private boolean stream;
    @SerializedName("config")
    @Expose
    private Object config;

    /**
     * 
     * @return
     *     The stream
     */
    public boolean isStream() {
        return stream;
    }

    /**
     * 
     * @param stream
     *     The stream
     */
    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public Pir withStream(boolean stream) {
        this.stream = stream;
        return this;
    }

    /**
     * 
     * @return
     *     The config
     */
    public Object getConfig() {
        return config;
    }

    /**
     * 
     * @param config
     *     The config
     */
    public void setConfig(Object config) {
        this.config = config;
    }

    public Pir withConfig(Object config) {
        this.config = config;
        return this;
    }

}

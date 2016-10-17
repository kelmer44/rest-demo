
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wifi {

    @SerializedName("config")
    @Expose
    private Config_ config;

    /**
     * 
     * @return
     *     The config
     */
    public Config_ getConfig() {
        return config;
    }

    /**
     * 
     * @param config
     *     The config
     */
    public void setConfig(Config_ config) {
        this.config = config;
    }

    public Wifi withConfig(Config_ config) {
        this.config = config;
        return this;
    }

}

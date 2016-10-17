
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ethernet {

    @SerializedName("config")
    @Expose
    private Config config;

    /**
     * 
     * @return
     *     The config
     */
    public Config getConfig() {
        return config;
    }

    /**
     * 
     * @param config
     *     The config
     */
    public void setConfig(Config config) {
        this.config = config;
    }

    public Ethernet withConfig(Config config) {
        this.config = config;
        return this;
    }

}

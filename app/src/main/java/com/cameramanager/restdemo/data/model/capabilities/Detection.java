
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detection {

    @SerializedName("pir")
    @Expose
    private Pir pir;

    /**
     * 
     * @return
     *     The pir
     */
    public Pir getPir() {
        return pir;
    }

    /**
     * 
     * @param pir
     *     The pir
     */
    public void setPir(Pir pir) {
        this.pir = pir;
    }

    public Detection withPir(Pir pir) {
        this.pir = pir;
        return this;
    }

}

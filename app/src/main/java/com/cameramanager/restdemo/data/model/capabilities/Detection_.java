
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detection_ {

    @SerializedName("pir")
    @Expose
    private boolean pir;
    @SerializedName("audio")
    @Expose
    private boolean audio;

    /**
     * 
     * @return
     *     The pir
     */
    public boolean isPir() {
        return pir;
    }

    /**
     * 
     * @param pir
     *     The pir
     */
    public void setPir(boolean pir) {
        this.pir = pir;
    }

    public Detection_ withPir(boolean pir) {
        this.pir = pir;
        return this;
    }

    /**
     * 
     * @return
     *     The audio
     */
    public boolean isAudio() {
        return audio;
    }

    /**
     * 
     * @param audio
     *     The audio
     */
    public void setAudio(boolean audio) {
        this.audio = audio;
    }

    public Detection_ withAudio(boolean audio) {
        this.audio = audio;
        return this;
    }

}

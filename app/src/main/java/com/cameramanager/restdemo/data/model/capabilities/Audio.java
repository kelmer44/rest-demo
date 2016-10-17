
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Audio {

    @SerializedName("microphone")
    @Expose
    private boolean microphone;
    @SerializedName("speaker")
    @Expose
    private boolean speaker;

    /**
     * 
     * @return
     *     The microphone
     */
    public boolean isMicrophone() {
        return microphone;
    }

    /**
     * 
     * @param microphone
     *     The microphone
     */
    public void setMicrophone(boolean microphone) {
        this.microphone = microphone;
    }

    public Audio withMicrophone(boolean microphone) {
        this.microphone = microphone;
        return this;
    }

    /**
     * 
     * @return
     *     The speaker
     */
    public boolean isSpeaker() {
        return speaker;
    }

    /**
     * 
     * @param speaker
     *     The speaker
     */
    public void setSpeaker(boolean speaker) {
        this.speaker = speaker;
    }

    public Audio withSpeaker(boolean speaker) {
        this.speaker = speaker;
        return this;
    }

}

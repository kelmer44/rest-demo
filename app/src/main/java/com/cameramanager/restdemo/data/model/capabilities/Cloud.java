
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cloud {

    @SerializedName("detection")
    @Expose
    private Detection_ detection;
    @SerializedName("schedule")
    @Expose
    private Schedule schedule;
    @SerializedName("continuous")
    @Expose
    private boolean continuous;
    @SerializedName("triggered")
    @Expose
    private boolean triggered;

    /**
     * 
     * @return
     *     The detection
     */
    public Detection_ getDetection() {
        return detection;
    }

    /**
     * 
     * @param detection
     *     The detection
     */
    public void setDetection(Detection_ detection) {
        this.detection = detection;
    }

    public Cloud withDetection(Detection_ detection) {
        this.detection = detection;
        return this;
    }

    /**
     * 
     * @return
     *     The schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * 
     * @param schedule
     *     The schedule
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Cloud withSchedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    /**
     * 
     * @return
     *     The continuous
     */
    public boolean isContinuous() {
        return continuous;
    }

    /**
     * 
     * @param continuous
     *     The continuous
     */
    public void setContinuous(boolean continuous) {
        this.continuous = continuous;
    }

    public Cloud withContinuous(boolean continuous) {
        this.continuous = continuous;
        return this;
    }

    /**
     * 
     * @return
     *     The triggered
     */
    public boolean isTriggered() {
        return triggered;
    }

    /**
     * 
     * @param triggered
     *     The triggered
     */
    public void setTriggered(boolean triggered) {
        this.triggered = triggered;
    }

    public Cloud withTriggered(boolean triggered) {
        this.triggered = triggered;
        return this;
    }

}

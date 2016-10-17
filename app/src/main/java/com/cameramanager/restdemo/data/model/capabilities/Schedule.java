
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schedule {

    @SerializedName("weekly")
    @Expose
    private boolean weekly;
    @SerializedName("date")
    @Expose
    private boolean date;

    /**
     * 
     * @return
     *     The weekly
     */
    public boolean isWeekly() {
        return weekly;
    }

    /**
     * 
     * @param weekly
     *     The weekly
     */
    public void setWeekly(boolean weekly) {
        this.weekly = weekly;
    }

    public Schedule withWeekly(boolean weekly) {
        this.weekly = weekly;
        return this;
    }

    /**
     * 
     * @return
     *     The date
     */
    public boolean isDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(boolean date) {
        this.date = date;
    }

    public Schedule withDate(boolean date) {
        this.date = date;
        return this;
    }

}

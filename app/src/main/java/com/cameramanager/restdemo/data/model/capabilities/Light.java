
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Light {

    @SerializedName("front")
    @Expose
    private Front front;

    /**
     * 
     * @return
     *     The front
     */
    public Front getFront() {
        return front;
    }

    /**
     * 
     * @param front
     *     The front
     */
    public void setFront(Front front) {
        this.front = front;
    }

    public Light withFront(Front front) {
        this.front = front;
        return this;
    }

}

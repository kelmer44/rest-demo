
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Night {

    @SerializedName("colorView")
    @Expose
    private boolean colorView;

    /**
     * 
     * @return
     *     The colorView
     */
    public boolean isColorView() {
        return colorView;
    }

    /**
     * 
     * @param colorView
     *     The colorView
     */
    public void setColorView(boolean colorView) {
        this.colorView = colorView;
    }

    public Night withColorView(boolean colorView) {
        this.colorView = colorView;
        return this;
    }

}


package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Front {

    @SerializedName("white")
    @Expose
    private boolean white;

    /**
     * 
     * @return
     *     The white
     */
    public boolean isWhite() {
        return white;
    }

    /**
     * 
     * @param white
     *     The white
     */
    public void setWhite(boolean white) {
        this.white = white;
    }

    public Front withWhite(boolean white) {
        this.white = white;
        return this;
    }

}


package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Io {

    @SerializedName("input")
    @Expose
    private boolean input;
    @SerializedName("output")
    @Expose
    private boolean output;

    /**
     * 
     * @return
     *     The input
     */
    public boolean isInput() {
        return input;
    }

    /**
     * 
     * @param input
     *     The input
     */
    public void setInput(boolean input) {
        this.input = input;
    }

    public Io withInput(boolean input) {
        this.input = input;
        return this;
    }

    /**
     * 
     * @return
     *     The output
     */
    public boolean isOutput() {
        return output;
    }

    /**
     * 
     * @param output
     *     The output
     */
    public void setOutput(boolean output) {
        this.output = output;
    }

    public Io withOutput(boolean output) {
        this.output = output;
        return this;
    }

}


package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Protocols {

    @SerializedName("80211a")
    @Expose
    private boolean _80211a;
    @SerializedName("80211g")
    @Expose
    private boolean _80211g;
    @SerializedName("80211n")
    @Expose
    private boolean _80211n;

    /**
     * 
     * @return
     *     The _80211a
     */
    public boolean is80211a() {
        return _80211a;
    }

    /**
     * 
     * @param _80211a
     *     The 80211a
     */
    public void set80211a(boolean _80211a) {
        this._80211a = _80211a;
    }

    public Protocols with80211a(boolean _80211a) {
        this._80211a = _80211a;
        return this;
    }

    /**
     * 
     * @return
     *     The _80211g
     */
    public boolean is80211g() {
        return _80211g;
    }

    /**
     * 
     * @param _80211g
     *     The 80211g
     */
    public void set80211g(boolean _80211g) {
        this._80211g = _80211g;
    }

    public Protocols with80211g(boolean _80211g) {
        this._80211g = _80211g;
        return this;
    }

    /**
     * 
     * @return
     *     The _80211n
     */
    public boolean is80211n() {
        return _80211n;
    }

    /**
     * 
     * @param _80211n
     *     The 80211n
     */
    public void set80211n(boolean _80211n) {
        this._80211n = _80211n;
    }

    public Protocols with80211n(boolean _80211n) {
        this._80211n = _80211n;
        return this;
    }

}

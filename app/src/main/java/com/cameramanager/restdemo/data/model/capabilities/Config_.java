
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Config_ {

    @SerializedName("disable")
    @Expose
    private boolean disable;
    @SerializedName("ipv4")
    @Expose
    private Ipv4_ ipv4;
    @SerializedName("protocols")
    @Expose
    private Protocols protocols;
    @SerializedName("security")
    @Expose
    private Security security;

    /**
     * 
     * @return
     *     The disable
     */
    public boolean isDisable() {
        return disable;
    }

    /**
     * 
     * @param disable
     *     The disable
     */
    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public Config_ withDisable(boolean disable) {
        this.disable = disable;
        return this;
    }

    /**
     * 
     * @return
     *     The ipv4
     */
    public Ipv4_ getIpv4() {
        return ipv4;
    }

    /**
     * 
     * @param ipv4
     *     The ipv4
     */
    public void setIpv4(Ipv4_ ipv4) {
        this.ipv4 = ipv4;
    }

    public Config_ withIpv4(Ipv4_ ipv4) {
        this.ipv4 = ipv4;
        return this;
    }

    /**
     * 
     * @return
     *     The protocols
     */
    public Protocols getProtocols() {
        return protocols;
    }

    /**
     * 
     * @param protocols
     *     The protocols
     */
    public void setProtocols(Protocols protocols) {
        this.protocols = protocols;
    }

    public Config_ withProtocols(Protocols protocols) {
        this.protocols = protocols;
        return this;
    }

    /**
     * 
     * @return
     *     The security
     */
    public Security getSecurity() {
        return security;
    }

    /**
     * 
     * @param security
     *     The security
     */
    public void setSecurity(Security security) {
        this.security = security;
    }

    public Config_ withSecurity(Security security) {
        this.security = security;
        return this;
    }

}

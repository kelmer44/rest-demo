
package com.cameramanager.restdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Camera {

    @SerializedName("cameraId")
    @Expose
    private Long cameraId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("deviceId")
    @Expose
    private Long deviceId;
    @SerializedName("accountId")
    @Expose
    private Long accountId;
    @SerializedName("online")
    @Expose
    private Boolean online;
    @SerializedName("zoneId")
    @Expose
    private Long zoneId;

    /**
     * 
     * @return
     *     The cameraId
     */
    public Long getCameraId() {
        return cameraId;
    }

    /**
     * 
     * @param cameraId
     *     The cameraId
     */
    public void setCameraId(Long cameraId) {
        this.cameraId = cameraId;
    }

    public Camera withCameraId(Long cameraId) {
        this.cameraId = cameraId;
        return this;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Camera withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The deviceId
     */
    public Long getDeviceId() {
        return deviceId;
    }

    /**
     * 
     * @param deviceId
     *     The deviceId
     */
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Camera withDeviceId(Long deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    /**
     * 
     * @return
     *     The accountId
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * 
     * @param accountId
     *     The accountId
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Camera withAccountId(Long accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * 
     * @return
     *     The online
     */
    public Boolean getOnline() {
        return online;
    }

    /**
     * 
     * @param online
     *     The online
     */
    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Camera withOnline(Boolean online) {
        this.online = online;
        return this;
    }

    /**
     * 
     * @return
     *     The zoneId
     */
    public Long getZoneId() {
        return zoneId;
    }

    /**
     * 
     * @param zoneId
     *     The zoneId
     */
    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Camera withZoneId(Long zoneId) {
        this.zoneId = zoneId;
        return this;
    }

}

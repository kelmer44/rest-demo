
package com.cameramanager.restdemo.data.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CameraStream {

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
    @SerializedName("streamId")
    @Expose
    private Long streamId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("tracks")
    @Expose
    private List<Track> tracks = new ArrayList<Track>();
    @SerializedName("urls")
    @Expose
    private List<String> urls = new ArrayList<String>();

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

    public CameraStream withCameraId(Long cameraId) {
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

    public CameraStream withName(String name) {
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

    public CameraStream withDeviceId(Long deviceId) {
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

    public CameraStream withAccountId(Long accountId) {
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

    public CameraStream withOnline(Boolean online) {
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

    public CameraStream withZoneId(Long zoneId) {
        this.zoneId = zoneId;
        return this;
    }

    /**
     * 
     * @return
     *     The streamId
     */
    public Long getStreamId() {
        return streamId;
    }

    /**
     * 
     * @param streamId
     *     The streamId
     */
    public void setStreamId(Long streamId) {
        this.streamId = streamId;
    }

    public CameraStream withStreamId(Long streamId) {
        this.streamId = streamId;
        return this;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public CameraStream withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The tracks
     */
    public List<Track> getTracks() {
        return tracks;
    }

    /**
     * 
     * @param tracks
     *     The tracks
     */
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public CameraStream withTracks(List<Track> tracks) {
        this.tracks = tracks;
        return this;
    }

    /**
     * 
     * @return
     *     The urls
     */
    public List<String> getUrls() {
        return urls;
    }

    /**
     * 
     * @param urls
     *     The urls
     */
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public CameraStream withUrls(List<String> urls) {
        this.urls = urls;
        return this;
    }

}

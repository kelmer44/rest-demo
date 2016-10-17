
package com.cameramanager.restdemo.data.model.capabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CameraCapabilities {

    @SerializedName("cameraId")
    @Expose
    private long cameraId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("deviceId")
    @Expose
    private long deviceId;
    @SerializedName("accountId")
    @Expose
    private long accountId;
    @SerializedName("online")
    @Expose
    private boolean online;
    @SerializedName("zoneId")
    @Expose
    private long zoneId;
    @SerializedName("ptz")
    @Expose
    private Ptz ptz;
    @SerializedName("detection")
    @Expose
    private Detection detection;
    @SerializedName("audio")
    @Expose
    private Audio audio;
    @SerializedName("io")
    @Expose
    private Io io;
    @SerializedName("light")
    @Expose
    private Light light;
    @SerializedName("night")
    @Expose
    private Night night;
    @SerializedName("stream")
    @Expose
    private Stream stream;
    @SerializedName("record")
    @Expose
    private Record record;
    @SerializedName("networking")
    @Expose
    private Networking networking;

    /**
     * 
     * @return
     *     The cameraId
     */
    public long getCameraId() {
        return cameraId;
    }

    /**
     * 
     * @param cameraId
     *     The cameraId
     */
    public void setCameraId(long cameraId) {
        this.cameraId = cameraId;
    }

    public CameraCapabilities withCameraId(long cameraId) {
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

    public CameraCapabilities withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The deviceId
     */
    public long getDeviceId() {
        return deviceId;
    }

    /**
     * 
     * @param deviceId
     *     The deviceId
     */
    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public CameraCapabilities withDeviceId(long deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    /**
     * 
     * @return
     *     The accountId
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * 
     * @param accountId
     *     The accountId
     */
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public CameraCapabilities withAccountId(long accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * 
     * @return
     *     The online
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * 
     * @param online
     *     The online
     */
    public void setOnline(boolean online) {
        this.online = online;
    }

    public CameraCapabilities withOnline(boolean online) {
        this.online = online;
        return this;
    }

    /**
     * 
     * @return
     *     The zoneId
     */
    public long getZoneId() {
        return zoneId;
    }

    /**
     * 
     * @param zoneId
     *     The zoneId
     */
    public void setZoneId(long zoneId) {
        this.zoneId = zoneId;
    }

    public CameraCapabilities withZoneId(long zoneId) {
        this.zoneId = zoneId;
        return this;
    }

    /**
     * 
     * @return
     *     The ptz
     */
    public Ptz getPtz() {
        return ptz;
    }

    /**
     * 
     * @param ptz
     *     The ptz
     */
    public void setPtz(Ptz ptz) {
        this.ptz = ptz;
    }

    public CameraCapabilities withPtz(Ptz ptz) {
        this.ptz = ptz;
        return this;
    }

    /**
     * 
     * @return
     *     The detection
     */
    public Detection getDetection() {
        return detection;
    }

    /**
     * 
     * @param detection
     *     The detection
     */
    public void setDetection(Detection detection) {
        this.detection = detection;
    }

    public CameraCapabilities withDetection(Detection detection) {
        this.detection = detection;
        return this;
    }

    /**
     * 
     * @return
     *     The audio
     */
    public Audio getAudio() {
        return audio;
    }

    /**
     * 
     * @param audio
     *     The audio
     */
    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public CameraCapabilities withAudio(Audio audio) {
        this.audio = audio;
        return this;
    }

    /**
     * 
     * @return
     *     The io
     */
    public Io getIo() {
        return io;
    }

    /**
     * 
     * @param io
     *     The io
     */
    public void setIo(Io io) {
        this.io = io;
    }

    public CameraCapabilities withIo(Io io) {
        this.io = io;
        return this;
    }

    /**
     * 
     * @return
     *     The light
     */
    public Light getLight() {
        return light;
    }

    /**
     * 
     * @param light
     *     The light
     */
    public void setLight(Light light) {
        this.light = light;
    }

    public CameraCapabilities withLight(Light light) {
        this.light = light;
        return this;
    }

    /**
     * 
     * @return
     *     The night
     */
    public Night getNight() {
        return night;
    }

    /**
     * 
     * @param night
     *     The night
     */
    public void setNight(Night night) {
        this.night = night;
    }

    public CameraCapabilities withNight(Night night) {
        this.night = night;
        return this;
    }

    /**
     * 
     * @return
     *     The stream
     */
    public Stream getStream() {
        return stream;
    }

    /**
     * 
     * @param stream
     *     The stream
     */
    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public CameraCapabilities withStream(Stream stream) {
        this.stream = stream;
        return this;
    }

    /**
     * 
     * @return
     *     The record
     */
    public Record getRecord() {
        return record;
    }

    /**
     * 
     * @param record
     *     The record
     */
    public void setRecord(Record record) {
        this.record = record;
    }

    public CameraCapabilities withRecord(Record record) {
        this.record = record;
        return this;
    }

    /**
     * 
     * @return
     *     The networking
     */
    public Networking getNetworking() {
        return networking;
    }

    /**
     * 
     * @param networking
     *     The networking
     */
    public void setNetworking(Networking networking) {
        this.networking = networking;
    }

    public CameraCapabilities withNetworking(Networking networking) {
        this.networking = networking;
        return this;
    }

}


package com.cameramanager.restdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("trackId")
    @Expose
    private Long trackId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("resolution")
    @Expose
    private Object resolution;
    @SerializedName("framerate")
    @Expose
    private Object framerate;
    @SerializedName("samplerate")
    @Expose
    private String samplerate;
    @SerializedName("codec")
    @Expose
    private String codec;
    @SerializedName("optional")
    @Expose
    private Boolean optional;

    /**
     * 
     * @return
     *     The trackId
     */
    public Long getTrackId() {
        return trackId;
    }

    /**
     * 
     * @param trackId
     *     The trackId
     */
    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public Track withTrackId(Long trackId) {
        this.trackId = trackId;
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

    public Track withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The resolution
     */
    public Object getResolution() {
        return resolution;
    }

    /**
     * 
     * @param resolution
     *     The resolution
     */
    public void setResolution(Object resolution) {
        this.resolution = resolution;
    }

    public Track withResolution(Object resolution) {
        this.resolution = resolution;
        return this;
    }

    /**
     * 
     * @return
     *     The framerate
     */
    public Object getFramerate() {
        return framerate;
    }

    /**
     * 
     * @param framerate
     *     The framerate
     */
    public void setFramerate(Object framerate) {
        this.framerate = framerate;
    }

    public Track withFramerate(Object framerate) {
        this.framerate = framerate;
        return this;
    }

    /**
     * 
     * @return
     *     The samplerate
     */
    public String getSamplerate() {
        return samplerate;
    }

    /**
     * 
     * @param samplerate
     *     The samplerate
     */
    public void setSamplerate(String samplerate) {
        this.samplerate = samplerate;
    }

    public Track withSamplerate(String samplerate) {
        this.samplerate = samplerate;
        return this;
    }

    /**
     * 
     * @return
     *     The codec
     */
    public String getCodec() {
        return codec;
    }

    /**
     * 
     * @param codec
     *     The codec
     */
    public void setCodec(String codec) {
        this.codec = codec;
    }

    public Track withCodec(String codec) {
        this.codec = codec;
        return this;
    }

    /**
     * 
     * @return
     *     The optional
     */
    public Boolean getOptional() {
        return optional;
    }

    /**
     * 
     * @param optional
     *     The optional
     */
    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public Track withOptional(Boolean optional) {
        this.optional = optional;
        return this;
    }

}

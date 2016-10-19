
package com.cameramanager.restdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("userId")
    @Expose
    private long userId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("familyName")
    @Expose
    private String familyName;
    @SerializedName("givenName")
    @Expose
    private String givenName;

    /**
     *
     * @return
     *     The userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     *     The userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public User withUserId(long userId) {
        this.userId = userId;
        return this;
    }

    /**
     *
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     *
     * @return
     *     The familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     *
     * @param familyName
     *     The familyName
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public User withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    /**
     *
     * @return
     *     The givenName
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     *
     * @param givenName
     *     The givenName
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public User withGivenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

}


package com.cameramanager.restdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Zone {

    @SerializedName("zoneId")
    @Expose
    private Long zoneId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("phone2")
    @Expose
    private Object phone2;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("accountId")
    @Expose
    private Long accountId;

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

    public Zone withZoneId(Long zoneId) {
        this.zoneId = zoneId;
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

    public Zone withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    public Zone withAddress(Address address) {
        this.address = address;
        return this;
    }

    /**
     * 
     * @return
     *     The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Zone withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * 
     * @return
     *     The phone2
     */
    public Object getPhone2() {
        return phone2;
    }

    /**
     * 
     * @param phone2
     *     The phone2
     */
    public void setPhone2(Object phone2) {
        this.phone2 = phone2;
    }

    public Zone withPhone2(Object phone2) {
        this.phone2 = phone2;
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

    public Zone withEmail(String email) {
        this.email = email;
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

    public Zone withAccountId(Long accountId) {
        this.accountId = accountId;
        return this;
    }

}

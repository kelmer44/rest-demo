package com.cameramanager.restdemo.data.source;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public class Zone {
    private long zoneId;
    private String name;
    private String phone;
    private String email;
    private long accountId;

    public Zone(final long zoneId, final String phone, final String name, final String email, final long accountId) {
        this.zoneId = zoneId;
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.accountId = accountId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(final long accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public long getZoneId() {
        return zoneId;
    }

    public void setZoneId(final long zoneId) {
        this.zoneId = zoneId;
    }
}

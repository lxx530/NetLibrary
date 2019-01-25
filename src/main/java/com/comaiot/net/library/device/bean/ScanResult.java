package com.comaiot.net.library.device.bean;

import java.io.Serializable;

public class ScanResult implements Serializable {
    private String app_aid;
    private String wifi_password;
    private String wifi_ssid;
    private String nonce;
    private String scanToken;

    public String getScanToken() {
        return scanToken;
    }

    public void setScanToken(String scanToken) {
        this.scanToken = scanToken;
    }

    public String getApp_aid() {
        return app_aid;
    }

    public void setApp_aid(String app_aid) {
        this.app_aid = app_aid;
    }

    public String getWifi_password() {
        return wifi_password;
    }

    public void setWifi_password(String wifi_password) {
        this.wifi_password = wifi_password;
    }

    public String getWifi_ssid() {
        return wifi_ssid;
    }

    public void setWifi_ssid(String wifi_ssid) {
        this.wifi_ssid = wifi_ssid;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "ScanResult{" +
                "app_aid='" + app_aid + '\'' +
                ", wifi_password='" + wifi_password + '\'' +
                ", wifi_ssid='" + wifi_ssid + '\'' +
                ", nonce='" + nonce + '\'' +
                ", scanToken='" + scanToken + '\'' +
                '}';
    }
}

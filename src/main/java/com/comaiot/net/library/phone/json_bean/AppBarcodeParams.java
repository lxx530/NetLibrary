package com.comaiot.net.library.phone.json_bean;

public class AppBarcodeParams {
    private String app_uid;
    private String app_envid;
    private String app_aid;
    private String token;
    private String wifi_ssid;
    private String wifi_password;

    public String getApp_uid() {
        return app_uid;
    }

    public void setApp_uid(String app_uid) {
        this.app_uid = app_uid;
    }

    public String getApp_envid() {
        return app_envid;
    }

    public void setApp_envid(String app_envid) {
        this.app_envid = app_envid;
    }

    public String getApp_aid() {
        return app_aid;
    }

    public void setApp_aid(String app_aid) {
        this.app_aid = app_aid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getWifi_ssid() {
        return wifi_ssid;
    }

    public void setWifi_ssid(String wifi_ssid) {
        this.wifi_ssid = wifi_ssid;
    }

    public String getWifi_password() {
        return wifi_password;
    }

    public void setWifi_password(String wifi_password) {
        this.wifi_password = wifi_password;
    }

    @Override
    public String toString() {
        return "AppBarcodeParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", app_aid='" + app_aid + '\'' +
                ", token='" + token + '\'' +
                ", wifi_ssid='" + wifi_ssid + '\'' +
                ", wifi_password='" + wifi_password + '\'' +
                '}';
    }
}

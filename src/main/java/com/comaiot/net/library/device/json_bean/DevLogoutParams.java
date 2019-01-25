package com.comaiot.net.library.device.json_bean;

public class DevLogoutParams {
    private String dev_uid;
    private String token;

    public String getDev_uid() {
        return dev_uid;
    }

    public void setDev_uid(String dev_uid) {
        this.dev_uid = dev_uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "DevLogoutParams{" +
                "dev_uid='" + dev_uid + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

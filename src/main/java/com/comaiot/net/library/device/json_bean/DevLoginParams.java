package com.comaiot.net.library.device.json_bean;

public class DevLoginParams {
    private String dev_uid;
    private String password;

    public String getDev_uid() {
        return dev_uid;
    }

    public void setDev_uid(String dev_uid) {
        this.dev_uid = dev_uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DevLoginParams{" +
                "dev_uid='" + dev_uid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package com.comaiot.net.library.phone.json_bean;

public class SmsParams {
    private String app_uid;
    private String phone_num;
    private String app_envid;

    public String getApp_uid() {
        return app_uid;
    }

    public void setApp_uid(String app_uid) {
        this.app_uid = app_uid;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getApp_envid() {
        return app_envid;
    }

    public void setApp_envid(String app_envid) {
        this.app_envid = app_envid;
    }

    @Override
    public String toString() {
        return "SmsParams{" +
                "app_uid='" + app_uid + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", app_envid='" + app_envid + '\'' +
                '}';
    }
}

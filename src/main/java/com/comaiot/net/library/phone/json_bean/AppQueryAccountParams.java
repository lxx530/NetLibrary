package com.comaiot.net.library.phone.json_bean;

public class AppQueryAccountParams {
    private String app_uid;
    private String app_envid;
    private String phone_num;
    private String subscribe_type;

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

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getSubscribe_type() {
        return subscribe_type;
    }

    public void setSubscribe_type(String subscribe_type) {
        this.subscribe_type = subscribe_type;
    }

    @Override
    public String toString() {
        return "AppQueryAccountParams{" +
                "app_uid='" + app_uid + '\'' +
                ", app_envid='" + app_envid + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", subscribe_type='" + subscribe_type + '\'' +
                '}';
    }
}

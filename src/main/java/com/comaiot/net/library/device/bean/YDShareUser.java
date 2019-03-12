package com.comaiot.net.library.device.bean;

import java.io.Serializable;

public class YDShareUser implements Serializable {
    private int id;
    private String sn;
    private String user_name;
    private String phone_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "YDShareUser{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", user_name='" + user_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}

package com.comaiot.net.library.phone.json_bean;

public class ShareParams {
    private String sn;
    private String phone_number;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "ShareParams{" +
                "sn='" + sn + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}

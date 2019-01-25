package com.comaiot.net.library.device.json_bean;

public class DevQueryTimeReqParams {
    private String appak;
    private long timestamp;
    private String nonce;
    private String sign;

    public String getAppak() {
        return appak;
    }

    public void setAppak(String appak) {
        this.appak = appak;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "DevQueryTimeReqParams{" +
                "appak='" + appak + '\'' +
                ", timestamp=" + timestamp +
                ", nonce='" + nonce + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}

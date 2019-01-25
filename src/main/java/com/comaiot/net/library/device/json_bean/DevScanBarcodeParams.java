package com.comaiot.net.library.device.json_bean;

public class DevScanBarcodeParams {
    private String appak;
    private String scan_token;
    private long timestamp;
    private String nonce;
    private String sign;
    private String sn;
    private String mac;
    private String imei;
    private String product;
    private String version;
    private String network_type;
    private String wifi_ssid;
    private String wifi_password;
    private String config;

    public String getAppak() {
        return appak;
    }

    public void setAppak(String appak) {
        this.appak = appak;
    }

    public String getScan_token() {
        return scan_token;
    }

    public void setScan_token(String scan_token) {
        this.scan_token = scan_token;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNetwork_type() {
        return network_type;
    }

    public void setNetwork_type(String network_type) {
        this.network_type = network_type;
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

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "DevScanBarcodeParams{" +
                "appak='" + appak + '\'' +
                ", scan_token='" + scan_token + '\'' +
                ", timestamp=" + timestamp +
                ", nonce='" + nonce + '\'' +
                ", sign='" + sign + '\'' +
                ", sn='" + sn + '\'' +
                ", mac='" + mac + '\'' +
                ", imei='" + imei + '\'' +
                ", product='" + product + '\'' +
                ", version='" + version + '\'' +
                ", network_type='" + network_type + '\'' +
                ", wifi_ssid='" + wifi_ssid + '\'' +
                ", wifi_password='" + wifi_password + '\'' +
                ", config='" + config + '\'' +
                '}';
    }
}

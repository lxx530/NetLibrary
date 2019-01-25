package com.comaiot.net.library.device.bean;

public class YDLockBeanEntity {
    private String length;
    private String type;
    private String val;

    private String serviceDataLength;
    private String serviceDateType;

    private String serviceUUID;

    private String productId;

    private String fram_c;

    private String capability;

    private int object;

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getServiceDataLength() {
        return serviceDataLength;
    }

    public void setServiceDataLength(String serviceDataLength) {
        this.serviceDataLength = serviceDataLength;
    }

    public String getServiceDateType() {
        return serviceDateType;
    }

    public void setServiceDateType(String serviceDateType) {
        this.serviceDateType = serviceDateType;
    }

    public String getServiceUUID() {
        return serviceUUID;
    }

    public void setServiceUUID(String serviceUUID) {
        this.serviceUUID = serviceUUID;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getFram_c() {
        return fram_c;
    }

    public void setFram_c(String fram_c) {
        this.fram_c = fram_c;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    public int getObject() {
        return object;
    }

    public void setObject(int object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "YDLockBeanEntity{" +
                "length='" + length + '\'' +
                ", type='" + type + '\'' +
                ", val='" + val + '\'' +
                ", serviceDataLength='" + serviceDataLength + '\'' +
                ", serviceDateType='" + serviceDateType + '\'' +
                ", serviceUUID='" + serviceUUID + '\'' +
                ", productId='" + productId + '\'' +
                ", fram_c='" + fram_c + '\'' +
                ", capability='" + capability + '\'' +
                ", object=" + object +
                '}';
    }
}

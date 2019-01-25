package com.comaiot.net.library.phone.bean;

import java.io.Serializable;

public class DeviceEntity implements Serializable {
    private AppQueryDeviceListEntity.BindDeviceData bindDeviceData;
    private boolean isDeviceOnline = false;

    /**
     * @return 设备列表数据
     */
    public AppQueryDeviceListEntity.BindDeviceData getBindDeviceData() {
        return bindDeviceData;
    }

    public void setBindDeviceData(AppQueryDeviceListEntity.BindDeviceData bindDeviceData) {
        this.bindDeviceData = bindDeviceData;
    }

    /**
     * @return 设备在线状态
     */
    public boolean isDeviceOnline() {
        return isDeviceOnline;
    }

    public void setDeviceOnline(boolean deviceOnline) {
        isDeviceOnline = deviceOnline;
    }

    @Override
    public String toString() {
        return "DeviceEntity{" +
                "bindDeviceData=" + bindDeviceData +
                ", isDeviceOnline=" + isDeviceOnline +
                '}';
    }
}

package com.comaiot.net.library.device.bean;

public class DeviceBusyCmd extends CmdInfo {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DeviceBusyCmd{" +
                "status='" + status + '\'' +
                '}';
    }
}

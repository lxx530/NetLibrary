package com.comaiot.net.library.device.bean;

public class RemoveAccountCmd extends CmdInfo {
    private String appUid;

    public String getAppUid() {
        return appUid;
    }

    public void setAppUid(String appUid) {
        this.appUid = appUid;
    }

    @Override
    public String toString() {
        return "RemoveAccountCmd{" +
                "appUid='" + appUid + '\'' +
                '}';
    }
}

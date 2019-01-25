package com.comaiot.net.library.phone.bean;

import java.io.Serializable;

public class RemoveAccount implements Serializable {
    private String cmd;
    private String removeId;
    private String appUid;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getRemoveId() {
        return removeId;
    }

    public void setRemoveId(String removeId) {
        this.removeId = removeId;
    }

    public String getAppUid() {
        return appUid;
    }

    public void setAppUid(String appUid) {
        this.appUid = appUid;
    }

    @Override
    public String toString() {
        return "RemoveAccount{" +
                "cmd='" + cmd + '\'' +
                ", removeId='" + removeId + '\'' +
                ", appUid='" + appUid + '\'' +
                '}';
    }
}

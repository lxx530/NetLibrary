package com.comaiot.net.library.device.bean;

import java.io.Serializable;

public class RemoveShareUserEntity implements Serializable {
    private String cmd;
    private String clientId;
    private String removeId;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRemoveId() {
        return removeId;
    }

    public void setRemoveId(String removeId) {
        this.removeId = removeId;
    }

    @Override
    public String toString() {
        return "ResetEntity{" +
                "cmd='" + cmd + '\'' +
                ", clientId=" + clientId +
                ", removeId=" + removeId +
                '}';
    }
}

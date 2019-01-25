package com.comaiot.net.library.device.bean;

import java.io.Serializable;

public class AppControlDevice implements Serializable {
    private String cmd;
    private int control_type;
    private int status;
    private String url;
    private String clientId;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getControl_type() {
        return control_type;
    }

    public void setControl_type(int control_type) {
        this.control_type = control_type;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "AppControlDevice{" +
                "cmd='" + cmd + '\'' +
                ", control_type=" + control_type +
                ", status=" + status +
                ", url='" + url + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}

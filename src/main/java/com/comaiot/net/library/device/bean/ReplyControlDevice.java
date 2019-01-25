package com.comaiot.net.library.device.bean;

import java.io.Serializable;

public class ReplyControlDevice implements Serializable {
    private String cmd;
    private int status;
    private int control_type;
    private String url;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getControl_type() {
        return control_type;
    }

    public void setControl_type(int control_type) {
        this.control_type = control_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ReplyControlDevice{" +
                "cmd='" + cmd + '\'' +
                ", status=" + status +
                ", control_type=" + control_type +
                ", url='" + url + '\'' +
                '}';
    }
}

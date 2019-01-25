package com.comaiot.net.library.device.bean;

import java.io.Serializable;

public class ResetEntity implements Serializable {
    private String cmd;
    private int status;

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

    @Override
    public String toString() {
        return "ResetEntity{" +
                "cmd='" + cmd + '\'' +
                ", status=" + status +
                '}';
    }
}

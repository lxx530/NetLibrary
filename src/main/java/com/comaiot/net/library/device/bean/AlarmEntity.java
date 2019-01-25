package com.comaiot.net.library.device.bean;

public class AlarmEntity extends CmdInfo {
    private int uid;
    private String type;
    private String mode;
    private String url;
    private String from;

    public int getUid() {
        return uid;
    }
    public String getType() {
        return type;
    }
    public String getMode() {
        return mode;
    }
    public String getUrl() {
        return url;
    }
    public String getFrom() {
        return from;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "AlarmEntity{" +
                "uid=" + uid +
                "type=" + type +
                "mode=" + mode +
                "url=" + url +
                "from=" + from +
                '}';
    }
}

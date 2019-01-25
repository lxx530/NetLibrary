package com.comaiot.net.library.device.bean;

public class VideoUidEntity extends CmdInfo {
    private int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "VideoUidEntity{" +
                "uid=" + uid +
                '}';
    }
}

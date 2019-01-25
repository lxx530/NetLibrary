package com.comaiot.net.library.device.bean;

public class OpenVideoEntity {
    private String cmd;
    private String join_id;
    private int video_uid;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getJoin_id() {
        return join_id;
    }

    public void setJoin_id(String join_id) {
        this.join_id = join_id;
    }

    public int getVideo_uid() {
        return video_uid;
    }

    public void setVideo_uid(int video_uid) {
        this.video_uid = video_uid;
    }

    @Override
    public String toString() {
        return "OpenVideoEntity{" +
                "cmd='" + cmd + '\'' +
                ", join_id='" + join_id + '\'' +
                ", video_uid=" + video_uid +
                '}';
    }
}

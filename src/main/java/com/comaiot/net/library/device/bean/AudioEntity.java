package com.comaiot.net.library.device.bean;

public class AudioEntity extends CmdInfo{
    private String join_id;
    private int audio_uid;

    public String getJoin_id() {
        return join_id;
    }

    public void setJoin_id(String join_id) {
        this.join_id = join_id;
    }

    public int getAudio_uid() {
        return audio_uid;
    }

    public void setAudio_uid(int audio_uid) {
        this.audio_uid = audio_uid;
    }

    @Override
    public String toString() {
        return "AudioEntity{" +
                "join_id='" + join_id + '\'' +
                ", audio_uid=" + audio_uid +
                '}';
    }
}

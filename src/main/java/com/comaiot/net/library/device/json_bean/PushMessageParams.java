package com.comaiot.net.library.device.json_bean;

import java.io.Serializable;

public class PushMessageParams {
    private String dev_uid;
    private String token;
    private String title;
    private String content;
    private String customContent;
    private String sound;
    private int expire;

    public String getDev_uid() {
        return dev_uid;
    }

    public void setDev_uid(String dev_uid) {
        this.dev_uid = dev_uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCustomContent() {
        return customContent;
    }

    public void setCustomContent(String customContent) {
        this.customContent = customContent;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    @Override
    public String toString() {
        return "PushMessageParams{" +
                "dev_uid='" + dev_uid + '\'' +
                ", token='" + token + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", customContent=" + customContent +
                ", sound='" + sound + '\'' +
                ", expire=" + expire +
                '}';
    }

    public static final class CustomContent implements Serializable{
        private int base64 = 1;
        private int expireTime = 7200;
        private String option;

        public int getBase64() {
            return base64;
        }

        public void setBase64(int base64) {
            this.base64 = base64;
        }

        public int getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(int expireTime) {
            this.expireTime = expireTime;
        }

        public String getOption() {
            return option;
        }

        public void setOption(String option) {
            this.option = option;
        }

        @Override
        public String toString() {
            return "CustomContent{" +
                    "base64=" + base64 +
                    ", expireTime=" + expireTime +
                    ", option='" + option + '\'' +
                    '}';
        }
    }
}

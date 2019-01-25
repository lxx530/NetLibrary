package com.comaiot.net.library.device.bean;

import com.comaiot.net.library.phone.bean.BaseAppEntity;

import java.io.Serializable;

public class DevQueryTimeEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DevQueryTimeEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private long current_time;

        public long getCurrent_time() {
            return current_time;
        }

        public void setCurrent_time(long current_time) {
            this.current_time = current_time;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "current_time=" + current_time +
                    '}';
        }
    }
}

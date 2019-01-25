package com.comaiot.net.library.phone.bean;

import java.io.Serializable;

public class AppAidEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppAidEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private String aid;

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "aid='" + aid + '\'' +
                    '}';
        }
    }
}

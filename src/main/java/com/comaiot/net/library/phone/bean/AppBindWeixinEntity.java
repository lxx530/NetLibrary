package com.comaiot.net.library.phone.bean;

import java.io.Serializable;

public class AppBindWeixinEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppBindWeixinEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private String app_uid;
        private String app_envid;

        public String getApp_uid() {
            return app_uid;
        }

        public void setApp_uid(String app_uid) {
            this.app_uid = app_uid;
        }

        public String getApp_envid() {
            return app_envid;
        }

        public void setApp_envid(String app_envid) {
            this.app_envid = app_envid;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "app_uid='" + app_uid + '\'' +
                    ", app_envid='" + app_envid + '\'' +
                    '}';
        }
    }
}

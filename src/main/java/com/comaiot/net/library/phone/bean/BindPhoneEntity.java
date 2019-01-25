package com.comaiot.net.library.phone.bean;

import java.io.Serializable;

public class BindPhoneEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BindPhoneEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable {
        private String app_uid;

        public String getApp_uid() {
            return app_uid;
        }

        public void setApp_uid(String app_uid) {
            this.app_uid = app_uid;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "app_uid='" + app_uid + '\'' +
                    '}';
        }
    }
}

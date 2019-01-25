package com.comaiot.net.library.phone.bean;

import java.io.Serializable;

public class AppChangePasswordEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppChangePasswordEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable {
        private String phone_num;

        public String getPhone_num() {
            return phone_num;
        }

        public void setPhone_num(String phone_num) {
            this.phone_num = phone_num;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "phone_num='" + phone_num + '\'' +
                    '}';
        }
    }
}

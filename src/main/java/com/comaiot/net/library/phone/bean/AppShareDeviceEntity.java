package com.comaiot.net.library.phone.bean;

import java.io.Serializable;

public class AppShareDeviceEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppShareDeviceEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private String share_token;
        private String share_num;

        /**
         *
         * @return 生成二维码的字串
         */
        public String getShare_token() {
            return share_token;
        }

        public void setShare_token(String share_token) {
            this.share_token = share_token;
        }

        /**
         *
         * @return 用于分享的数字密码
         */
        public String getShare_num() {
            return share_num;
        }

        public void setShare_num(String share_num) {
            this.share_num = share_num;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "share_token='" + share_token + '\'' +
                    ", share_num='" + share_num + '\'' +
                    '}';
        }
    }
}

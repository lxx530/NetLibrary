package com.comaiot.net.library.phone.bean;

import java.io.Serializable;

public class AppBarcodeReqEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppBarcodeReqEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private String scan_token;

        public String getScan_token() {
            return scan_token;
        }

        public void setScan_token(String scan_token) {
            this.scan_token = scan_token;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "scan_token='" + scan_token + '\'' +
                    '}';
        }
    }
}

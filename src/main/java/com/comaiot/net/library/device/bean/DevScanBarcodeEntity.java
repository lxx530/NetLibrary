package com.comaiot.net.library.device.bean;

import com.comaiot.net.library.phone.bean.BaseAppEntity;

import java.io.Serializable;

public class DevScanBarcodeEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DevScanBarcodeEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private String devid;
        private String app_aid;
        private String app_uid;
        private String app_envid;
        private String dev_uid;
        private String password;
        private String old_dev_uid;
        private String old_app_aid;

        public String getDevid() {
            return devid;
        }

        public void setDevid(String devid) {
            this.devid = devid;
        }

        public String getApp_aid() {
            return app_aid;
        }

        public void setApp_aid(String app_aid) {
            this.app_aid = app_aid;
        }

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

        public String getDev_uid() {
            return dev_uid;
        }

        public void setDev_uid(String dev_uid) {
            this.dev_uid = dev_uid;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getOld_dev_uid() {
            return old_dev_uid;
        }

        public void setOld_dev_uid(String old_dev_uid) {
            this.old_dev_uid = old_dev_uid;
        }

        public String getOld_app_aid() {
            return old_app_aid;
        }

        public void setOld_app_aid(String old_app_aid) {
            this.old_app_aid = old_app_aid;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "devid='" + devid + '\'' +
                    ", app_aid='" + app_aid + '\'' +
                    ", app_uid='" + app_uid + '\'' +
                    ", app_envid='" + app_envid + '\'' +
                    ", dev_uid='" + dev_uid + '\'' +
                    ", password='" + password + '\'' +
                    ", old_dev_uid='" + old_dev_uid + '\'' +
                    ", old_app_aid='" + old_app_aid + '\'' +
                    '}';
        }
    }
}

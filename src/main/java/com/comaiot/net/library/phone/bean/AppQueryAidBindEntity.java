package com.comaiot.net.library.phone.bean;

import java.io.Serializable;

public class AppQueryAidBindEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static class Content implements Serializable {
        private String status;
        private String dev_uid;

        /**
         *
         * @return deviceId
         */
        public String getDev_uid() {
            return dev_uid;
        }

        public void setDev_uid(String dev_uid) {
            this.dev_uid = dev_uid;
        }

        /**
         *
         * @return 绑定状态
         */
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static final String NoRecord = "NoRecord";
    public static final String RecordWithoutDevUid = "RecordWithoutDevUid";
    public static final String RecordWithDevUid = "RecordWithDevUid";
    public static final String RecordBindBefore = "RecordBindBefore";
}

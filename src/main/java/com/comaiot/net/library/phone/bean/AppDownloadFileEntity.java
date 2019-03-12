package com.comaiot.net.library.phone.bean;

import java.io.Serializable;
import java.util.List;

public class AppDownloadFileEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppDownloadFileEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable{
        private int num;
        private List<FileInfo> list;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public List<FileInfo> getList() {
            return list;
        }

        public void setList(List<FileInfo> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "num=" + num +
                    ", list=" + list +
                    '}';
        }
    }

    public static class FileInfo implements Serializable{
        private String fileNumber;
        private String dev_uid;
        private long upload_date;
        private String src_filename;
        private String url;
        private String msg_type;
        private String file_type;
        private String from_where;
        private String from_id;
        private String deviceNickName;

        public String getFileNumber() {
            return fileNumber;
        }

        public void setFileNumber(String fileNumber) {
            this.fileNumber = fileNumber;
        }

        public String getDev_uid() {
            return dev_uid;
        }

        public void setDev_uid(String dev_uid) {
            this.dev_uid = dev_uid;
        }

        public long getUpload_date() {
            return upload_date;
        }

        public void setUpload_date(long upload_date) {
            this.upload_date = upload_date;
        }

        public String getSrc_filename() {
            return src_filename;
        }

        public void setSrc_filename(String src_filename) {
            this.src_filename = src_filename;
        }

        public void setDeviceNickName(String deviceNickName) {
            this.deviceNickName = deviceNickName;
        }

        public String getDeviceNickName() {
            return deviceNickName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMsg_type() {
            return msg_type;
        }

        public void setMsg_type(String msg_type) {
            this.msg_type = msg_type;
        }

        public String getFile_type() {
            return file_type;
        }

        public void setFile_type(String file_type) {
            this.file_type = file_type;
        }

        public String getFrom_where() {
            return from_where;
        }

        public void setFrom_where(String from_where) {
            this.from_where = from_where;
        }

        public String getFrom_id() {
            return from_id;
        }

        public void setFrom_id(String from_id) {
            this.from_id = from_id;
        }

        @Override
        public String toString() {
            return "FileInfo{" +
                    "fileNumber='" + fileNumber + '\'' +
                    ", dev_uid='" + dev_uid + '\'' +
                    ", upload_date=" + upload_date +
                    ", src_filename='" + src_filename + '\'' +
                    ", url='" + url + '\'' +
                    ", msg_type='" + msg_type + '\'' +
                    ", file_type='" + file_type + '\'' +
                    ", from_where='" + from_where + '\'' +
                    ", from_id='" + from_id + '\'' +
                    '}';
        }
    }
}

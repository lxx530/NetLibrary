package com.comaiot.net.library.device.json_bean;

public class DevUploadFileParams {
    private String dev_uid;
    private String token;
    private String src_filename;
    private String msg_type;
    private String file_type;
    private String from_where;
    private String from_id;
    private String url;

    public String getDev_uid() {
        return dev_uid;
    }

    public void setDev_uid(String dev_uid) {
        this.dev_uid = dev_uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSrc_filename() {
        return src_filename;
    }

    public void setSrc_filename(String src_filename) {
        this.src_filename = src_filename;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DevUploadFileParams{" +
                "dev_uid='" + dev_uid + '\'' +
                ", token='" + token + '\'' +
                ", src_filename='" + src_filename + '\'' +
                ", msg_type='" + msg_type + '\'' +
                ", file_type='" + file_type + '\'' +
                ", from_where='" + from_where + '\'' +
                ", from_id='" + from_id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

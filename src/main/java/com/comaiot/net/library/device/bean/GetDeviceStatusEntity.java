package com.comaiot.net.library.device.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetDeviceStatusEntity implements Serializable{
    private String cmd;
    private String deviceId;
    private int ring;
    private int sound;
    private int ring_light;
    private Person_Check person_check;
    private int alarm;
    private int language;
    private String wifi;
    private int mode;
    private int battery;
    private int wifi_rssi;
    private Device_Info deviceInfo;
    private String deviceNickName;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Device_Info getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(Device_Info deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getRing() {
        return ring;
    }

    public void setRing(int ring) {
        this.ring = ring;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getRing_light() {
        return ring_light;
    }

    public void setRing_light(int ring_light) {
        this.ring_light = ring_light;
    }

    public Person_Check getPerson_check() {
        return person_check;
    }

    public void setPerson_check(Person_Check person_check) {
        this.person_check = person_check;
    }

    public int getAlarm() {
        return alarm;
    }

    public void setAlarm(int alarm) {
        this.alarm = alarm;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getWifi_rssi() {
        return wifi_rssi;
    }

    public void setWifi_rssi(int wifi_rssi) {
        this.wifi_rssi = wifi_rssi;
    }

    public String getDeviceNickName() {
        return deviceNickName;
    }

    public void setDeviceNickName(String deviceNickName) {
        this.deviceNickName = deviceNickName;
    }

    @Override
    public String toString() {
        return "GetDeviceStatusEntity{" +
                "cmd='" + cmd + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", ring=" + ring +
                ", sound=" + sound +
                ", ring_light=" + ring_light +
                ", person_check=" + person_check +
                ", alarm=" + alarm +
                ", language=" + language +
                ", wifi='" + wifi + '\'' +
                ", mode=" + mode +
                ", battery=" + battery +
                ", wifi_rssi=" + wifi_rssi +
                ", deviceInfo=" + deviceInfo +
                ", deviceNickName='" + deviceNickName + '\'' +
                '}';
    }

    public static class Person_Check implements Serializable{
        @SerializedName("switch")
        private int switch_check;
        private int auto_pic;
        private int ring_light;
        private int notification_duration;
        private int sensitive;
        private int alarm_mode;
        private int tack_pic_num;
        private int out_door_alarm;
        private int out_door_sound;
        private int out_door_ring;

        public int getSwitch_check() {
            return switch_check;
        }

        public void setSwitch_check(int switch_check) {
            this.switch_check = switch_check;
        }

        public int getAuto_pic() {
            return auto_pic;
        }

        public void setAuto_pic(int auto_pic) {
            this.auto_pic = auto_pic;
        }

        public int getRing_light() {
            return ring_light;
        }

        public void setRing_light(int ring_light) {
            this.ring_light = ring_light;
        }

        public int getNotification_duration() {
            return notification_duration;
        }

        public void setNotification_duration(int notification_duration) {
            this.notification_duration = notification_duration;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
        }

        public int getAlarm_mode() {
            return alarm_mode;
        }

        public void setAlarm_mode(int alarm_mode) {
            this.alarm_mode = alarm_mode;
        }

        public int getTack_pic_num() {
            return tack_pic_num;
        }

        public void setTack_pic_num(int tack_pic_num) {
            this.tack_pic_num = tack_pic_num;
        }

        public int getOut_door_alarm() {
            return out_door_alarm;
        }

        public void setOut_door_alarm(int out_door_alarm) {
            this.out_door_alarm = out_door_alarm;
        }

        public int getOut_door_sound() {
            return out_door_sound;
        }

        public void setOut_door_sound(int out_door_sound) {
            this.out_door_sound = out_door_sound;
        }

        public int getOut_door_ring() {
            return out_door_ring;
        }

        public void setOut_door_ring(int out_door_ring) {
            this.out_door_ring = out_door_ring;
        }

        @Override
        public String toString() {
            return "Person_Check{" +
                    "switch_check=" + switch_check +
                    ", auto_pic=" + auto_pic +
                    ", ring_light=" + ring_light +
                    ", notification_duration=" + notification_duration +
                    ", sensitive=" + sensitive +
                    ", alarm_mode=" + alarm_mode +
                    ", tack_pic_num=" + tack_pic_num +
                    ", out_door_alarm=" + out_door_alarm +
                    ", out_door_sound=" + out_door_sound +
                    ", out_door_ring=" + out_door_ring +
                    '}';
        }
    }

    public static class Device_Info implements Serializable{
        private String version_info;
        private String firm_version;
        private String version;
        private long total_stroage;
        private long use_stroage;
        private String new_firm_version;
        private String new_firm_download;

        public String getVersion_info() {
            return version_info;
        }

        public void setVersion_info(String version_info) {
            this.version_info = version_info;
        }

        public String getFirm_version() {
            return firm_version;
        }

        public void setFirm_version(String firm_version) {
            this.firm_version = firm_version;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public long getTotal_stroage() {
            return total_stroage;
        }

        public void setTotal_stroage(long total_stroage) {
            this.total_stroage = total_stroage;
        }

        public long getUse_stroage() {
            return use_stroage;
        }

        public void setUse_stroage(long use_stroage) {
            this.use_stroage = use_stroage;
        }

        public String getNew_firm_version() {
            return new_firm_version;
        }

        public void setNew_firm_version(String new_firm_version) {
            this.new_firm_version = new_firm_version;
        }

        public String getNew_firm_download() {
            return new_firm_download;
        }

        public void setNew_firm_download(String new_firm_download) {
            this.new_firm_download = new_firm_download;
        }

        @Override
        public String toString() {
            return "Device_Info{" +
                    "version_info='" + version_info + '\'' +
                    ", firm_version='" + firm_version + '\'' +
                    ", version='" + version + '\'' +
                    ", total_stroage=" + total_stroage +
                    ", use_stroage=" + use_stroage +
                    ", new_firm_version='" + new_firm_version + '\'' +
                    ", new_firm_download='" + new_firm_download + '\'' +
                    '}';
        }
    }
}

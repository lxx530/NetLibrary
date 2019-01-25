package com.comaiot.net.library.device.bean;


import java.io.Serializable;

public class DeviceStatusChangeEntity implements Serializable {
    private String cmd;
    private Wifi wifi;
    private Ring ring;
    private Battery battery;
    private GetDeviceStatusEntity device_status;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Wifi getWifi() {
        return wifi;
    }

    public void setWifi(Wifi wifi) {
        this.wifi = wifi;
    }

    public Ring getRing() {
        return ring;
    }

    public void setRing(Ring ring) {
        this.ring = ring;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public GetDeviceStatusEntity getDevice_status() {
        return device_status;
    }

    public void setDevice_status(GetDeviceStatusEntity device_status) {
        this.device_status = device_status;
    }

    @Override
    public String toString() {
        return "DeviceStatusChangeEntity{" +
                "cmd='" + cmd + '\'' +
                ", wifi=" + wifi +
                ", ring=" + ring +
                ", battery=" + battery +
                ", device_status=" + device_status +
                '}';
    }

    public static class Wifi implements Serializable{
        private String ssid;
        private int wifi_rssi;

        public String getSsid() {
            return ssid;
        }

        public void setSsid(String ssid) {
            this.ssid = ssid;
        }

        public int getWifi_rssi() {
            return wifi_rssi;
        }

        public void setWifi_rssi(int wifi_rssi) {
            this.wifi_rssi = wifi_rssi;
        }

        @Override
        public String toString() {
            return "Wifi{" +
                    "ssid='" + ssid + '\'' +
                    ", wifi_rssi=" + wifi_rssi +
                    '}';
        }
    }

    public static class Ring implements Serializable{
        private int index;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "Ring{" +
                    "index=" + index +
                    '}';
        }
    }

    public static class Battery implements Serializable{
        private int device_battery;
        private boolean battery_low;
        private int device;
        private String deviceId;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public int getDevice_battery() {
            return device_battery;
        }

        public void setDevice_battery(int device_battery) {
            this.device_battery = device_battery;
        }

        public boolean isBattery_low() {
            return battery_low;
        }

        public void setBattery_low(boolean battery_low) {
            this.battery_low = battery_low;
        }

        public int getDevice() {
            return device;
        }

        public void setDevice(int device) {
            this.device = device;
        }

        @Override
        public String toString() {
            return "Battery{" +
                    "device_battery=" + device_battery +
                    ", battery_low=" + battery_low +
                    ", device=" + device +
                    ", deviceId='" + deviceId + '\'' +
                    '}';
        }
    }
}

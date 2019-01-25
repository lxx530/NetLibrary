package com.comaiot.net.library.device.bean;

import java.io.Serializable;
import java.util.Arrays;

public class ConfigEntity {
    private Device[] device;

    public Device[] getDevice() {
        return device;
    }

    public void setDevice(Device[] device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "ConfigEntity{" +
                "device=" + Arrays.toString(device) +
                '}';
    }

    public static class Device implements Serializable {
        private String manufacturerName;
        private String protocolType;
        private String deviceType;
        private String devicesNumber;
        private String SN;
        private String applicationType;
        private String softwareVersion;
        private String commands;
        private Property[] properties;

        public String getManufacturerName() {
            return manufacturerName;
        }

        public void setManufacturerName(String manufacturerName) {
            this.manufacturerName = manufacturerName;
        }

        public String getProtocolType() {
            return protocolType;
        }

        public void setProtocolType(String protocolType) {
            this.protocolType = protocolType;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getDevicesNumber() {
            return devicesNumber;
        }

        public void setDevicesNumber(String devicesNumber) {
            this.devicesNumber = devicesNumber;
        }

        public String getSN() {
            return SN;
        }

        public void setSN(String SN) {
            this.SN = SN;
        }

        public String getApplicationType() {
            return applicationType;
        }

        public void setApplicationType(String applicationType) {
            this.applicationType = applicationType;
        }

        public String getSoftwareVersion() {
            return softwareVersion;
        }

        public void setSoftwareVersion(String softwareVersion) {
            this.softwareVersion = softwareVersion;
        }

        public String getCommands() {
            return commands;
        }

        public void setCommands(String commands) {
            this.commands = commands;
        }

        public Property[] getProperties() {
            return properties;
        }

        public void setProperties(Property[] properties) {
            this.properties = properties;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "manufacturerName='" + manufacturerName + '\'' +
                    ", protocolType='" + protocolType + '\'' +
                    ", deviceType='" + deviceType + '\'' +
                    ", devicesNumber='" + devicesNumber + '\'' +
                    ", SN='" + SN + '\'' +
                    ", applicationType='" + applicationType + '\'' +
                    ", softwareVersion='" + softwareVersion + '\'' +
                    ", commands='" + commands + '\'' +
                    ", properties=" + Arrays.toString(properties) +
                    '}';
        }
    }

    public static class Property implements Serializable{
        private String propertyName;
        private String propertyData;

        public String getPropertyName() {
            return propertyName;
        }

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }

        public String getPropertyData() {
            return propertyData;
        }

        public void setPropertyData(String propertyData) {
            this.propertyData = propertyData;
        }

        @Override
        public String toString() {
            return "Property{" +
                    "propertyName='" + propertyName + '\'' +
                    ", propertyData='" + propertyData + '\'' +
                    '}';
        }
    }
}

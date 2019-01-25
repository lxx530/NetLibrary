package com.comaiot.net.library.device.bean;

import java.io.Serializable;

public class SetDeviceSettingEntity implements Serializable {
    private String cmd;
    private String clientId;
    private String deviceNickName;
    private DeviceStatusChangeEntity.Ring ring;
    private GetDeviceStatusEntity.Person_Check person_check;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDeviceNickName() {
        return deviceNickName;
    }

    public void setDeviceNickName(String deviceNickName) {
        this.deviceNickName = deviceNickName;
    }

    @Override
    public String toString() {
        return "SetDeviceSettingEntity{" +
                "cmd='" + cmd + '\'' +
                ", clientId='" + clientId + '\'' +
                ", deviceNickName='" + deviceNickName + '\'' +
                ", ring=" + ring +
                ", person_check=" + person_check +
                '}';
    }

    public DeviceStatusChangeEntity.Ring getRing() {
        return ring;
    }

    public void setRing(DeviceStatusChangeEntity.Ring ring) {
        this.ring = ring;
    }

    public GetDeviceStatusEntity.Person_Check getPerson_check() {
        return person_check;
    }

    public void setPerson_check(GetDeviceStatusEntity.Person_Check person_check) {
        this.person_check = person_check;
    }

}

package com.comaiot.net.library.phone.view;

import com.comaiot.net.library.device.bean.AlarmEntity;
import com.comaiot.net.library.device.bean.AppControlDevice;
import com.comaiot.net.library.device.bean.DeviceStatusChangeEntity;
import com.comaiot.net.library.device.bean.GetDeviceStatusEntity;
import com.comaiot.net.library.device.bean.SetDeviceSettingEntity;

public interface OnCatMessageArriveListener {
    /**
     * 猫眼上线
     */
    void onCatDeviceOnline(String devId);

    /**
     * 猫眼状态属性发生改变
     *
     * @param entity
     */
    void onCatDeviceStatusChanged(DeviceStatusChangeEntity entity, String devId);

    /**
     * 拿取猫眼状态属性成功回调
     *
     * @param entity
     */
    void onGetCatDeviceStatusSuccess(GetDeviceStatusEntity entity, String devId);

    /**
     * 猫眼准备重启
     */
    void onCatDeviceResetPrepare(String devId);

    /**
     * 对猫眼设置完成
     */
    void onCatDeviceConfigComplete(SetDeviceSettingEntity entity, String devId);

    /**
     * 猫眼报警信息上传
     *
     * @param entity
     */
    void onCatDeviceAlarmArrived(AlarmEntity entity, String devId);

    /**
     * 控制猫眼成功回调
     */
    void onCatDeviceControlComplete(AppControlDevice controlDevice, String devId);

    /**
     * 猫眼下线通知
     */
    void onCatDeviceOffline(String devId);
}

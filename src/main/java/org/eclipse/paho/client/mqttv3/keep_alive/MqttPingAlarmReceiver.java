package org.eclipse.paho.client.mqttv3.keep_alive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

import com.comaiot.net.library.phone.okhttp.Logger;

import org.greenrobot.eventbus.EventBus;

public class MqttPingAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (null != intent && null != intent.getAction() && intent.getAction().equals(CustomKeepAliveManager.MQTT_PING_ALARM_ACTION)) {
            Logger.ii("MqttPingAlarmReceiver receive ");

            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            PowerManager.WakeLock wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE, "Comaiot_Dev");

            if (null != wakeLock) {
                wakeLock.acquire(3000);
                Logger.ii("MqttPingAlarmReceiver Lock and acquire 3s");
            }
        }
    }
}

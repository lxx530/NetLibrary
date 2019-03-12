package org.eclipse.paho.client.mqttv3.keep_alive;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class CustomKeepAliveManager {

    public static final String MQTT_PING_ALARM_ACTION = "comaiot.mqtt.ping.request.action";
    public static final String MQTT_PING_WAKEUP_ACTION = "comaiot.mqtt.ping.wake.up.action";
    public static final int MQTT_PING_ALARM_CODE = 1001;
    public static final int MQTT_PING_WAKEUP_CODE = 1002;

    private static Context mContext;
    private static PendingIntent mPrePendingIntent;

    public static final void init(Context context) {
        mContext = context;
    }

    public static final AlarmManager getAlarmManager() {
        return (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
    }

    public static void sendAlarmBroadCast(int nextPingTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, nextPingTime);

        if (null != mPrePendingIntent)
            getAlarmManager().cancel(mPrePendingIntent);

        Intent intent = new Intent(mContext, MqttPingAlarmReceiver.class);
        intent.setAction(MQTT_PING_ALARM_ACTION);
        mPrePendingIntent = PendingIntent.getBroadcast(mContext, MQTT_PING_ALARM_CODE, intent, 0);
        getAlarmManager().set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), mPrePendingIntent);
    }

    public static void sendAlarmWakeUp() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.MILLISECOND, 100);

        Intent intent = new Intent(mContext, MqttPingWakeUpReceiver.class);
        intent.setAction(MQTT_PING_WAKEUP_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, MQTT_PING_WAKEUP_CODE, intent, 0);
        getAlarmManager().set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
}

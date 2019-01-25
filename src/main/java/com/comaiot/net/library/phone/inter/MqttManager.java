package com.comaiot.net.library.phone.inter;

import android.content.Context;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MqttManager {
    private static MqttManager mqttManager = null;
    private final Context mContext;
    private MqttAndroidClient mClient;
    private MqttConnectOptions mOptions;

    private MessageHandlerCallBack callBack;
    private ConnectionHandlerCallBack mConnectCallBack;

    private boolean mIsConnecting = false;

    private MqttManager(Context context) {
        this.mContext = context;
    }

    /**
     * 获取一个MQTTManager单例
     *
     * @param context
     * @return 返回一个MQTTManager的实例对象
     */
    public static MqttManager getInstance(Context context) {
        if (mqttManager == null) {
            synchronized (MqttManager.class) {
                if (mqttManager == null) {
                    mqttManager = new MqttManager(context);
                }
            }
        }
        return mqttManager;
    }

    public static MqttManager get() {
        return mqttManager;
    }

    /**
     * 连接服务器
     */
    public void connect(String ipAddress, String clientId, String port, String userName, String password) {
        mIsConnecting = true;
        try {
            ipAddress = "tcp://" + ipAddress + ":" + port;
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            if (null == mClient)
                mClient = new MqttAndroidClient(mContext, ipAddress, clientId);
            // MQTT的连接设置
            if (null == mOptions)
                mOptions = new MqttConnectOptions();
            mOptions.setUserName(userName);
            mOptions.setCleanSession(false);
            // 设置连接的密码
            if (null == password) return;
            mOptions.setPassword(password.toCharArray());
            // 设置超时时间 单位为秒
            mOptions.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔300秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            mOptions.setKeepAliveInterval(300);
            mClient.setCallback(new PushCallback());
            mClient.connect(mOptions);
        } catch (MqttException e) {
            mIsConnecting = false;
            if (null != mConnectCallBack)
                mConnectCallBack.connectError(e);
        }
    }

    /**
     * 订阅消息
     *
     * @param topic 订阅消息的主题
     */
    public void subscribeMsg(String topic, int qos) {
        if (mClient != null) {
            int[] Qos = {qos};
            String[] topic1 = {topic};
            try {
                mClient.subscribe(topic1, Qos);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    public void unSubscribeMsg(String topic) {
        if (mClient != null) {
            String[] topic1 = {topic};
            try {
                mClient.unsubscribe(topic1);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发布消息
     *
     * @param topic      发布消息主题
     * @param msg        消息体
     * @param isRetained 是否为保留消息
     */
    public void publish(String topic, String msg, boolean isRetained, int qos) {
        try {
            if (mClient != null) {
                MqttMessage message = new MqttMessage();
                message.setQos(qos);
                message.setRetained(isRetained);
                message.setPayload(msg.getBytes());
                mClient.publish(topic, message);
            }
        } catch (MqttPersistenceException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发布消息
     *
     * @param topic      发布消息主题
     * @param msg        消息体
     * @param isRetained 是否为保留消息
     */
    public void publish(String topic, String msg, boolean isRetained, int qos, SendSocketMessageCallBack callBack) {
        try {
            if (mClient != null) {
                MqttMessage message = new MqttMessage();
                message.setQos(qos);
                message.setRetained(isRetained);
                message.setPayload(msg.getBytes());
                mClient.publish(topic, message, null, callBack);
            }
        } catch (MqttPersistenceException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    int count = 0;

    /**
     * 发布和订阅消息的回调
     */
    public class PushCallback implements MqttCallbackExtended {

        public void connectionLost(Throwable cause) {
            mIsConnecting = false;
            if (null != mConnectCallBack) mConnectCallBack.disconnect();
            int random = new Random().nextInt(1000);
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (count >= 5) {
                        count = 0;
                        cancel();
                    }
                    try {
                        if (null != mClient && !mClient.isConnected()) {
                            mClient.connect(mOptions);
                            count++;
                        } else if (null == mClient) {
                            cancel();
                            count = 0;
                        }
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }
            }, random, 10000);
        }

        /**
         * 发布消息的回调
         */
        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {
            //publish后会执行到这里
        }

        /**
         * 接收消息的回调方法
         */
        @Override
        public void messageArrived(final String topicName, final MqttMessage message) throws Exception {
            //subscribe后得到的消息会执行到这里面
            if (callBack != null) {
                callBack.messageSuccess(topicName, new String(message.getPayload()));
            }
        }

        @Override
        public void connectComplete(boolean reconnect, String serverURI) {
            mIsConnecting = false;
            callBack.connectComplete(reconnect, serverURI);
            if (null != mConnectCallBack)
                mConnectCallBack.connectComplete(reconnect, serverURI);
            count = 0;
        }
    }

    /**
     * 设置接收消息的回调方法
     *
     * @param callBack
     */
    public void setMessageHandlerCallBack(MessageHandlerCallBack callBack) {
        this.callBack = callBack;
    }

    public void setConnectionCallBack(ConnectionHandlerCallBack connectionCallBack) {
        this.mConnectCallBack = connectionCallBack;
    }

    public MessageHandlerCallBack getMessageHandlerCallBack() {
        if (callBack != null) {
            return callBack;
        }
        return null;
    }

    public ConnectionHandlerCallBack getmConnectCallBack() {
        return mConnectCallBack;
    }

    /**
     * 断开链接
     */
    public void disconnect() {
        if (mClient != null && mClient.isConnected()) {
            try {
                mClient.disconnect();
                mClient.unregisterResources();
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     */
    public void release() {
        if (mqttManager != null) {
            mqttManager = null;
        }
        if (null != mClient) {
            mClient = null;
        }
        if (null != mOptions) {
            mOptions = null;
        }
    }

    /**
     * 判断服务是否连接
     *
     * @return
     */
    public boolean isConnected() {
        if (mClient != null) {
            return mClient.isConnected();
        }
        return false;
    }

    public interface MessageHandlerCallBack {
        void messageSuccess(String topicName, String msg);

        void connectComplete(boolean reconnect, String serverURI);
    }

    public interface ConnectionHandlerCallBack {
        void connectError(Exception e);

        void disconnect();

        void connectComplete(boolean reconnect, String serverURI);
    }

    public String getClientId() {
        String clientId = null;
        if (null == mClient) return clientId;
        return mClient.getClientId();
    }

    public interface SendSocketMessageCallBack extends IMqttActionListener {

    }
}

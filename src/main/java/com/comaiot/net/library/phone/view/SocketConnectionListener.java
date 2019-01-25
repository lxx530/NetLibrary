package com.comaiot.net.library.phone.view;

public interface SocketConnectionListener {
    /**
     * 消息通道连接成功
     */
    void onSocketConnectSuccess();

    /**
     * 消息通道断开
     */
    void onSocketDisconnect();

    /**
     * 消息通道连接失败
     *
     * @param e 异常信息
     */
    void onSocketConnectError(Exception e);
}

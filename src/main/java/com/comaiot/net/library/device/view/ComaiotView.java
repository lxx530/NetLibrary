package com.comaiot.net.library.device.view;

public interface ComaiotView {
    /**
     * 开始请求网络
     */
    void showLoading();

    /**
     * 结束请求网络
     */
    void hideLoading();

    /**
     * 接口请求成功
     */
    void onRequestSuccess();

    /**
     * 接口请求失败
     *
     * @param errorMsg   错误信息
     * @param methodName 函数（方法）名称
     */
    void onRequestError(String errorMsg, String methodName);
}

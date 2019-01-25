package com.comaiot.net.library.phone.okhttp;

import org.json.JSONObject;

import java.io.IOException;

public interface OkHttpCallback {
    /**
     * 响应成功
     *
     * @param oriData JSON数据 自行解析
     */
    void onSuccess(JSONObject oriData);


    /**
     * 响应失败
     *
     * @param e 异常信息
     */
    void onFailure(IOException e);
}

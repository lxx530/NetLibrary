package com.comaiot.net.library.device.callback;

public interface CallBack<T> {
    void onStart();

    void onComplete();

    void onError(String msg);

    void onSuccess(T data);
}

package com.comaiot.net.library.device.view;

import com.comaiot.net.library.device.bean.BaseEntity;

public interface GetWeatherView extends ComaiotView {
    void onGetWeatherSuccess(BaseEntity baseEntity);
}

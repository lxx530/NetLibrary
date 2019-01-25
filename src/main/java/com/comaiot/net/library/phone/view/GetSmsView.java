package com.comaiot.net.library.phone.view;

import com.comaiot.net.library.device.view.ComaiotView;
import com.comaiot.net.library.phone.bean.BaseAppEntity;

public interface GetSmsView extends ComaiotView {
    void onSendSmsSuccess(BaseAppEntity entity);
}

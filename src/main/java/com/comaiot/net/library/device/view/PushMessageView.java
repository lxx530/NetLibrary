package com.comaiot.net.library.device.view;

import com.comaiot.net.library.phone.bean.BaseAppEntity;

public interface PushMessageView extends ComaiotView {
    void onPushMessageSuccess(BaseAppEntity baseAppEntity);
}

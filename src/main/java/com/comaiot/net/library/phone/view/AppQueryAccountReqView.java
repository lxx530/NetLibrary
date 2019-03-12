package com.comaiot.net.library.phone.view;

import com.comaiot.net.library.device.view.ComaiotView;
import com.comaiot.net.library.phone.bean.AppQueryAccountEntity;

public interface AppQueryAccountReqView extends ComaiotView {
    void onAppQueryAccountReqSuccess(AppQueryAccountEntity baseAppEntity);
}
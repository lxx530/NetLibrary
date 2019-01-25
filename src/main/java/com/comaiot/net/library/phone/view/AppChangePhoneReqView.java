package com.comaiot.net.library.phone.view;

import com.comaiot.net.library.device.view.ComaiotView;
import com.comaiot.net.library.phone.bean.AppChangePhoneEntity;

public interface AppChangePhoneReqView extends ComaiotView {
    void onAppChangePhoneReqSuccess(AppChangePhoneEntity baseAppEntity);
}

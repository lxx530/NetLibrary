package com.comaiot.net.library.phone.view;

import com.comaiot.net.library.device.view.ComaiotView;
import com.comaiot.net.library.phone.bean.AppChangePasswordEntity;
import com.comaiot.net.library.phone.bean.BaseAppEntity;

public interface AppChangePasswordReqView extends ComaiotView {
    void onAppChangePasswordReqSuccess(BaseAppEntity baseAppEntity);
}

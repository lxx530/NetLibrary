package com.comaiot.net.library.device.view;

import com.comaiot.net.library.device.bean.DevQueryTimeEntity;
import com.comaiot.net.library.phone.bean.BaseAppEntity;

public interface DevQueryTimeReqView extends ComaiotView {
    void onDevQueryTimeSuccess(BaseAppEntity baseAppEntity);
}

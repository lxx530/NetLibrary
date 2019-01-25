package com.comaiot.net.library.device.view;


import com.comaiot.net.library.phone.bean.BaseAppEntity;

public interface CallOwnerReqView extends ComaiotView {
    void onCallOwnerReqSuccess(BaseAppEntity baseAppEntity, String msg_type);
}

package com.comaiot.net.library.phone.view;

import com.comaiot.net.library.device.view.ComaiotView;
import com.comaiot.net.library.phone.bean.AppReceiveShareEntity;
import com.comaiot.net.library.phone.bean.AppReceiveShareNumEntity;
import com.comaiot.net.library.phone.bean.BaseAppEntity;

public interface AppReceiveShareReqView extends ComaiotView {
    void onAppReceiveShareReqSuccess(AppReceiveShareEntity baseAppEntity);
    void onAppReceiveShareNumReqSuccess(AppReceiveShareNumEntity baseAppEntity);
}

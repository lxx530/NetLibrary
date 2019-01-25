package com.comaiot.net.library.phone.view;

import com.comaiot.net.library.device.view.ComaiotView;
import com.comaiot.net.library.phone.bean.AppSubscribeEntity;
import com.comaiot.net.library.phone.bean.BaseAppEntity;

public interface AppWeChatSubscribeReqView extends ComaiotView {
    void onWeChatSubscribeSuccess(BaseAppEntity baseAppEntity, String appUid, String appEnvid, String weixin_code);
}

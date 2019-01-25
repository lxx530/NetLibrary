package com.comaiot.net.library.phone.view;

import com.comaiot.net.library.device.view.ComaiotView;
import com.comaiot.net.library.phone.bean.AppChangeAccountInfoEntity;
import com.comaiot.net.library.phone.bean.BaseAppEntity;

public interface AppChangeAccountInfoReqView extends ComaiotView {
    void onAppChangeAccountInfoReqSuccess(BaseAppEntity baseAppEntity);
}

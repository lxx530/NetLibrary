package com.comaiot.net.library.device.view;

import com.comaiot.net.library.device.bean.ArogaBean;

public interface AgoraLicensesView extends ComaiotView {
    void onAgoraLicensesGetSuccess(ArogaBean.Licenses licenses);
}
